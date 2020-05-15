package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_VisibilityConditions_isEnabled {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");

	}

	@Test
	void isEnabled() throws InterruptedException {

		driver.manage().window().maximize();

		Thread.sleep(2000);

		boolean buttonEnable = driver.findElement(By.id("create")).isEnabled();

		if (!buttonEnable) {

			System.out.println("Button is not enabled");

		} else {

			System.out.println("Button is enabled");

		}

		Thread.sleep(2000);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
