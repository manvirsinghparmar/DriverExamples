package WebDriver.Example;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome_ImplicitWait {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.koodomobile.com/");

		driver.manage().window().maximize();
		
		
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	void isSelected() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='https://www.koodomobile.com/my-account/overview']")).click();

		Thread.sleep(2500);

		driver.findElement(By.xpath("//input[@name='IDToken1']")).sendKeys("Enter your emailID here");

		driver.findElement(By.xpath("//*//input[@name='IDToken2']")).sendKeys("Enter your password");

		driver.findElement(
				By.xpath("//button[@class='KDS_Button-modules__primary___2hYEU KDS_Button-modules__button___iH8KX']"))
				.click();

		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='lch-button color-blue']")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//a[@class='lch-button color-blue']")).click();
	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
