package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ChromeBrowser_ebay {
	
	
	static WebDriver driver;

	@Test
	void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.ebay.ca/");

		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("iphone");



		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
	
		

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}


}
