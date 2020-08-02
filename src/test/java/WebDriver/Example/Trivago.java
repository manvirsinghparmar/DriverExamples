package WebDriver.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Trivago {

	WebDriver driver;
	WebDriverWait wait;

	SoftAssert sAssert;

	@BeforeMethod
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		sAssert = new SoftAssert();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
	}

	@Test
	void table() throws InterruptedException {

		// *[@id="customers"]/tbody/tr[2]/td[1]

		String xpathBefore = "//*[@id=\"customers\"]/tbody/tr[";

		String xpathAfter = "]/td[3]";

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));

		System.out.println(elements.size());

		for (int i = 2; i <= elements.size(); i++) {

			String path = xpathBefore + i + xpathAfter;

			WebElement element = driver.findElement(By.xpath(xpathBefore + i + xpathAfter));

			System.out.println(" The details are " + element.getText());
		}

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
