package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StaleElementExceptionCheck {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	SoftAssert sAssert;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		
		sAssert=new SoftAssert();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.google.co.in/");

		driver.manage().window().maximize();
	}
	
	
	
	@Test
	void stalelementExceptionCheck() {
		
		StaleElementExceptionCheck st=new StaleElementExceptionCheck();
		
		WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
		
		
		driver.navigate().refresh();
		
		
		searchBox.sendKeys("Trial for stale element exception");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}
	

}
