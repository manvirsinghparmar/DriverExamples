package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ChromeBrowser_OrangeHRM {

	static WebDriver driver;

	
	@Test
	void setUp() {
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
	
			String title= driver.getTitle();
			
			
			Assert.assertEquals("OrangeHRM",title );
	}
	
	
	@AfterClass
	void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);
		
		
		driver.quit();
	}

}
