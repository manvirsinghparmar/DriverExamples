package WebDriver.Example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Docker_Firefox {
	
	
	@Test
	void test1() throws MalformedURLException {

		DesiredCapabilities dc = DesiredCapabilities.firefox();

		URL url = new URL("http://192.168.99.100:4444/wd/hub");

		RemoteWebDriver dr = new RemoteWebDriver(url, dc);

		dr.get("https://www.softwaretestinghelp.com/docker-selenium-tutorial/");

		String titleOfPage = dr.getTitle();

		System.out.println("The Title of Page on Firefox Brower is: " + titleOfPage);
		
		dr.quit();

	}


}
