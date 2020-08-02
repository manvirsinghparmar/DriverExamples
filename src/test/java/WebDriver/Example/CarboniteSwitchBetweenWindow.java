package WebDriver.Example;

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



public class CarboniteSwitchBetweenWindow {
	
	
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

		driver.get("https://www.carbonite.com/");

		driver.manage().window().maximize();
	}
	
	
	
	@Test
	void switchBetweenWindoetest() {
		
		WebElement logo=driver.findElement(By.xpath("//img[@src='/globalassets/images/logos/logo-carbonite-opentext.svg']"));
		
		WebElement homeBackUp=driver.findElement(By.xpath("//a[contains(text(),'Home backup')]"));
		
		
		sAssert.assertTrue(logo.isDisplayed());
		
		homeBackUp.click();
		
		
		String pageTitle=driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Back up and protect files with Carbonite Safe | Carbonite");
		
		driver.navigate().back();
		
		String homePageTitle=driver.getTitle();
		
		Assert.assertEquals(homePageTitle, "Cloud backup solutions for home and business | Carbonite");
		
		sAssert.assertAll();
		
		driver.navigate().to("https://www.google.co.in/");
		
		
		
	}
	
	
	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}
	

}
