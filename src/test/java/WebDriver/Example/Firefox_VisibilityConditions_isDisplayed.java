package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_VisibilityConditions_isDisplayed {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		driver.manage().window().maximize();

	}

	@Test
	void isDisplayed() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("shaminder");
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
		
		Thread.sleep(2000);
		
		WebElement display=driver.findElement(By.xpath("//span[@id='display']"));
		
		String display_text=display.getText();
		
		Assert.assertEquals(display_text, "shaminder");

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
