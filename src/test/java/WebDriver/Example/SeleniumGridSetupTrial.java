package WebDriver.Example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridSetupTrial {

	public static WebDriver driver;

	@BeforeMethod
	void Setup()  {

		String nodeURL = " http://192.168.0.13:8080/wd/hub";

		DesiredCapabilities dCap = new DesiredCapabilities();
		dCap.setBrowserName("chrome");
		dCap.setPlatform(Platform.WINDOWS);
		dCap.setCapability("marionette", true);

		System.out.println("Executed 1");

		// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions cOption = new ChromeOptions();
		cOption.addArguments("allow-elevated-browser");	
		cOption.merge(dCap);
	

		System.out.println("Executed 2");

		try {
			driver = new RemoteWebDriver(new URL(nodeURL), dCap);
		} catch (MalformedURLException e) {
			System.out.println("The exception is :" + e);
		}

		System.out.println("Executed 3");
		

		driver.get("https://www.google.co.in/");

	}

	@Test
	void getTitle() {

		String pageTitle = driver.getTitle();

		Assert.assertEquals(pageTitle, "Google");

	}

	@AfterMethod
	void closeBrowser() {

		driver.quit();

	}

}
