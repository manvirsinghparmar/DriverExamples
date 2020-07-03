package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetWindowHandles {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.rogers.com");

		driver.manage().window().maximize();

		
		

	}

	@Test(priority = 1)
	void login() {

		driver.findElement(By.xpath("//span[@class='m-navLink__caption'][contains(text(),'Sign in')]")).click();
		
		String main=driver.getWindowHandle();
		
		System.out.println("The main handle is : "+ main);

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='el-modal ng-star-inserted']//iframe")));

		driver.findElement(By.id("username")).sendKeys("manvir.singh.parmar@gmail.com");// Enter your user name or email
																						// ID
		driver.findElement(By.id("password")).sendKeys("Manvir@1988"); // Enter your password

		driver.findElement(By.xpath("//button[@type='button' and  @data-dtname='signin submit' ]")).click();
		
		driver.switchTo().window(main);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
