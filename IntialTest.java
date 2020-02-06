import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntialTest {

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
		driver.findElement(By.xpath("//*[@id=\'GatherJobCodeList\']/tbody/tr[2]/td[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'featureForm\']/div[2]/div/div/div/div[3]/input[3]")).click();
		Thread.sleep(1000);
		driver.close();
		Thread.sleep(5000);
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
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		String url = "https://rollins.okta.com/login/login.htm?fromURI=%2Fhome%2Frollinscollege_timeclockplus_1%2F0oa1t9fmp5CiaW4J9357%2Faln1t9kgat2oTrfaq357";
		String username = "username";
		String password = "password";
		
		clockin(url,username,password);
		clockout(url, username, password);
		
	}
}
