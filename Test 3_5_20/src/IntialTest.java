
public class IntialTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		String url = "https://rollins.okta.com/login/login.htm?fromURI=%2Fhome%2Frollinscollege_timeclockplus_1%2F0oa1t9fmp5CiaW4J9357%2Faln1t9kgat2oTrfaq357";
		String username = "arashid";
		String password = "R01178989willgetmein";
		
		Clock.clockinTest(url,username,password);
		//Clock.clockinTest(url,username,password);
		Clock.clockoutTest(url, username, password);
		
		System.exit(0);
		
	}
}
