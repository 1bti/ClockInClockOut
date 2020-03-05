
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Clock {
	
	public static void clockin(String url, String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ClockIn")).click();
		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(By.cssSelector("td[ng-bind='objJobCode.strDescription']"));
		boolean hello;
		
		if(!elements.isEmpty()){
			//New Code 2/11/20
			//List<WebElement> elements = driver.findElements(By.cssSelector("td[ng-bind='objJobCode.strDescription']"));
			System.out.println(elements);
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
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[3]/input[3]")).click();
			Thread.sleep(1000);
			sc.close();
			driver.close();
		}
		else {
			driver.close();
			Thread.sleep(5000);
		}
	}
	
	public static void clockinTest(String url, String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ClockIn")).click();
		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(By.cssSelector("td[ng-bind='objJobCode.strDescription']"));
		Boolean missedClockOut = driver.findElements(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[2]/div[1]")).size() > 0;
		
		if(!elements.isEmpty()){
			//New Code 2/11/20
			//List<WebElement> elements = driver.findElements(By.cssSelector("td[ng-bind='objJobCode.strDescription']"));
			System.out.println(elements);
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
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[3]/input[3]")).click();
			Thread.sleep(1000);
			sc.close();
			driver.close();
		}
		else if(missedClockOut) {
			System.out.println("Missed Clock Out");
		}
		else {
			//driver.close();
			Thread.sleep(5000);
		}
	}
	
	public static void clockout(String url, String username, String password) throws InterruptedException {
		WebDriver driver2 = new ChromeDriver();
		driver2.get(url);
		Thread.sleep(4000);
		driver2.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50);
		driver2.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000);
		driver2.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000);
		driver2.findElement(By.id("ClockOut")).click();
		Thread.sleep(1000);
		driver2.close();
		
	}
	
	public static void clockoutTest(String url, String username, String password) throws InterruptedException {
		WebDriver driver2 = new ChromeDriver();
		driver2.get(url);
		Thread.sleep(1000);
		driver2.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(username);
		Thread.sleep(50);
		driver2.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys(password);
		Thread.sleep(1000);
		driver2.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(5000);
		driver2.findElement(By.id("ClockOut")).click();
		Thread.sleep(1000);
		Boolean missedClockIn = driver2.findElements(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[2]/div[1]")).size() > 0;
		if(missedClockIn){
			System.out.println("Missed ClockIn");
		}
		//driver2.close();
		
	}
}
