package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome_RogersLogin {
	
	//This class is specifically used to implement and check Modal window , how to know its locator and switch

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.rogers.com");

		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	void login() throws InterruptedException {

		driver.findElement(By.xpath("//span[@class='m-navLink__caption'][contains(text(),'Sign in')]")).click();

		Thread.sleep(1000);

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='el-modal ng-star-inserted']//iframe")));

		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("Enter your username");// Enter your user name or email ID

		driver.findElement(By.id("password")).sendKeys("Enter your password"); // Enter your password

		driver.findElement(By.xpath("//button[@type='button' and  @data-dtname='signin submit' ]")).click();

	}
	
	
	
	@Test(priority = 2)
	void viewBill() {
		
		
		driver.findElement(By.xpath("//button[@title='View current bill']")).click();
		
		
		
		
		
	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
