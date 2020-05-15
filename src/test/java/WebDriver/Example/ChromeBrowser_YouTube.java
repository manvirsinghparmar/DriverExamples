package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ChromeBrowser_YouTube {

	static WebDriver driver;

	@Test
	void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.youtube.com/");
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium sdet");



		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//ytd-channel-name[@id='channel-title']//yt-formatted-string[@id='text']")).click();		
		
		Thread.sleep(1500);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		
		
		
		
		driver.navigate().forward();

		
		driver.navigate().to("https://www.google.ca/");
		
	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
