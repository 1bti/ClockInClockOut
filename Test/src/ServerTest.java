// A Java program for a Server 
import java.net.*; 
import java.io.*; 
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServerTest 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null;
	
	public static void clockin(String url, String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50/2);
		driver.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000/2);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000/2);
		driver.findElement(By.id("ClockIn")).click();
		Thread.sleep(1000/2);
		
		//New Code 2/11/20
		List<WebElement> elements = driver.findElements(By.cssSelector("td[ng-bind='objJobCode.strDescription']"));
		if (!elements.isEmpty()) {
		System.out.println("Which Job?");
		int i = 0;
        while (i < elements.size()) {
            int choice = i + 1;
        	System.out.println(choice + " " + elements.get(i).getText());
            i++;
        }
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        String xpathJob = "//*[@id=\'GatherJobCodeList\']/tbody/tr[" + Integer.toString(selection) + "]/td[3]";
		//
        
        driver.findElement(By.xpath(xpathJob)).click();
		Thread.sleep(3000/2);
		driver.findElement(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[3]/input[3]")).click();
		Thread.sleep(1000/2);
		sc.close();
		driver.close();
		}
		
		else {
			driver.close();
			Thread.sleep(5000/2);
		}
	}
	
	public static void clockout(String url, String username, String password) throws InterruptedException {
		WebDriver driver2 = new ChromeDriver();
		driver2.get(url);
		Thread.sleep(4000/2);
		driver2.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50/2);
		driver2.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000/2);
		driver2.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000/2);
		driver2.findElement(By.id("ClockOut")).click();
		Thread.sleep(1000/2);
		driver2.close();
		
	}
	// constructor with port 
	public ServerTest(int port) throws InterruptedException 
	{  
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 
			//while (true) {
			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = "";
			String username = "";
			String password = "";
			String url = "https://rollins.okta.com/login/login.htm?fromURI=%2Fhome%2Frollinscollege_timeclockplus_1%2F0oa1t9fmp5CiaW4J9357%2Faln1t9kgat2oTrfaq357";
			
			line = in.readUTF();
			username = line;
			
			line = in.readUTF();
			password = line;
			
			clockin(url,username,password);
			clockout(url, username, password);
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		//} 
	}
		catch(IOException i) 
		{ 
			System.out.println(i); 
		}
	}
		
	

	public static void main(String args[]) throws InterruptedException 
	{ 
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ServerTest server = new ServerTest(4997); 
	} 
} 


