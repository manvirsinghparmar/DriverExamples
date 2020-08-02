package WebDriver.Example;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class FluentWait {

	WebDriver driver;

	WebDriverWait webWait;

	@BeforeMethod
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		webWait = new WebDriverWait(driver, 15);

		driver.get("https://www.walmart.ca/en");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	public void fluentWait() {

		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS).pollingEvery(4, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(
						"//div[@aria-hidden='false']//div[@src='https://i5.walmartimages.com/dfw/8822aef6-985c/k2-_90cfc182-3448-4f58-8c77-69be52b67844.v1.jpg']"));
			}
		});

		foo.click();

		WebElement pageConfirmationTitle = driver
				.findElement(By.xpath("//h1[contains(text(),'Top Deals in Electronics')]"));

		Assert.assertEquals(pageConfirmationTitle.getText(), "Top Deals in Electronics");

		driver.navigate().back();

		WebElement foo2 = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath(
						"//div[@aria-hidden='false']//div[@src='https://i5.walmartimages.com/dfw/8822aef6-ba7a/k2-_4b9c69e9-3cce-42e5-8dd2-3e3735dcfd73.v1.jpg']"));
			}
		});

		foo2.click();

		WebElement cross = driver.findElement(By.cssSelector(".sliver-close-button"));

		cross.click();

		WebElement logo = driver.findElement(By.xpath("//span[contains(text(),'Grocery')]"));

		Assert.assertTrue(logo.isDisplayed());

	}

	@AfterMethod
	void tearDown() {

		try {
			System.out.println("Closing Browser");
		} finally {
			driver.quit();
		}
	}

}
