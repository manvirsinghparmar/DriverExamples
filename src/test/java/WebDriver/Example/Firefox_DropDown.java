package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_DropDown {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

	}

	@Test(priority = 1)
	void Dropdown() throws InterruptedException {

		driver.manage().window().maximize();

		Select selectByDay = new Select(driver.findElement(By.id("select-demo")));

		selectByDay.selectByValue("Wednesday");

		Thread.sleep(2000);

		

	}

	@Test(priority = 2)
	void MultiSelect() throws InterruptedException {

		

		Select selectbyName = new Select(
				driver.findElement(By.id("multi-select")));

		selectbyName.selectByVisibleText("New York");

		Thread.sleep(500);

		driver.findElement(By.id("printMe")).click();

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
