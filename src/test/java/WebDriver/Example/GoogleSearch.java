package WebDriver.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleSearch {

	WebDriver driver;
	WebDriverWait wait;

	SoftAssert sAssert;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		sAssert = new SoftAssert();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.google.co.in/");

		driver.manage().window().maximize();
	}

	@Test()
	void search() {

		WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));

		searchBox.sendKeys("finland");

		List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(text(),'finland')]"));

		System.out.println("Total number of element is " + searchResults.size());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < searchResults.size(); i++) {

			System.out.println("Value of i " + i);

			Assert.assertTrue(searchResults.get(i).getText().contains("finland"), "Sucess");

		}

		String firstIndexText = searchResults.get(0).getText();
		System.out.println("Text is " + firstIndexText);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		try {
			System.out.println("Closing Browser");

		} finally {
			Thread.sleep(5000);

			driver.quit();

		}

	}

}
