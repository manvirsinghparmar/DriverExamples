package WebDriver.Example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Docker_chrome {

	@Test
	void test1() throws MalformedURLException {

		DesiredCapabilities dc = DesiredCapabilities.chrome();

		URL url = new URL("http://192.168.99.100:4444/wd/hub");

		RemoteWebDriver dr = new RemoteWebDriver(url, dc);

		dr.get("https://www.google.co.in/");

		String titleOfPage = dr.getTitle();

		System.out.println("The Title of Page on Chrome Brower is: " + titleOfPage);
		
		dr.quit();

	}

}
