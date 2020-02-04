import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rollins.okta.com/login/login.htm?fromURI=%2Fhome%2Frollinscollege_timeclockplus_1%2F0oa1t9fmp5CiaW4J9357%2Faln1t9kgat2oTrfaq357");
		
		driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys("Username");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'okta-signin-password\']")).sendKeys("Password");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'ClockIn\']")).click();
	
		
		//driver.close();
	}

}
