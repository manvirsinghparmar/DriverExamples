package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_gmail {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

	}

	@Test
	void login() throws InterruptedException {

		driver.get(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.manage().window().maximize();

		Thread.sleep(100);

		driver.findElement(By.id("identifierId")).sendKeys("Enter your email ID");

		Thread.sleep(1000);

		driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"))
				.sendKeys("Enter your password");

		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span"))
				.click();

		Thread.sleep(1000);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
