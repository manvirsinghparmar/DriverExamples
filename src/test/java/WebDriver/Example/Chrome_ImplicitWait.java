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

import junit.framework.Assert;

public class Chrome_ImplicitWait {

	WebDriver driver;
	
	WebDriverWait wait; 

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();

		driver.get("https://www.koodomobile.com/");

	}

	@Test
	void isSelected() {

		driver.findElement(By.xpath("//a[@href='https://www.koodomobile.com/my-account/overview']")).click();

		driver.findElement(By.xpath("//input[@name='IDToken1']")).sendKeys("manvir.singh.parmar@gmail.com");

		driver.findElement(By.xpath("//*//input[@name='IDToken2']")).sendKeys("Manvir@1988");

		driver.findElement(
				By.xpath("//button[@class='KDS_Button-modules__primary___2hYEU KDS_Button-modules__button___iH8KX']"))
				.click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='lch-button color-blue']")));
		// click on the compose button as soon as the "compose" button is visible
		 int height=driver.findElement(By.xpath("//a[@class='lch-button color-blue']")).getSize().getHeight();
		 int width=  driver.findElement(By.xpath("//a[@class='lch-button color-blue']")).getSize().getWidth();
		 System.out.println("The height is: " + height);
		 System.out.println("The height is: " + width);
		 
		 WebElement element=driver.findElement(By.xpath("//a[@class='lch-button color-blue']"));
		 
		 driver.navigate().to("https://www.google.com/");
		 
		 WebElement elementGoogle=driver.findElement(By.id("hplogo"));
		 
		boolean flag=elementGoogle.isDisplayed();
		
		Assert.assertTrue(flag);
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		
		System.out.println("Window handles are: " + windowHandles);
		
		
		driver.navigate().back();
		 
		
		 
		 
		
	}

	@AfterClass
	void tearDown() {

		driver.quit();
	}

}
