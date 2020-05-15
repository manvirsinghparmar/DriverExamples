package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_VisibilityConditions_isSelected {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

	}

	@Test
	void isSelected() throws InterruptedException {

		driver.manage().window().maximize();

		driver.findElement(By.id("isAgeSelected")).click();

		Thread.sleep(2000);

		boolean checkBoxSelected = driver.findElement(By.id("isAgeSelected")).isSelected();

		if (!checkBoxSelected) {

			System.out.println("Check Box is not selected");

		} else {

			System.out.println("Check Box is selected");

		}

		Thread.sleep(2000);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
