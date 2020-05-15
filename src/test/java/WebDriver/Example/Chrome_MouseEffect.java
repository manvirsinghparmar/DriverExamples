package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chrome_MouseEffect {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.insureincanada.ca/");

		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	void mouseHover() throws InterruptedException {

		Actions actions = new Actions(driver);
		WebElement vistorInsurance = driver.findElement(By.xpath("//a[text()='Visitors Insurance']"));
		
		WebElement onlyVistor=driver.findElement(By.id("menu-item-5667"));
		
		WebElement newImmigrants=driver.findElement(By.id("menu-item-5665"));
		actions.moveToElement(vistorInsurance).build().perform();
		
		actions.moveToElement(onlyVistor).build().perform();
		
		actions.moveToElement(newImmigrants).click().build().perform();
		
		Thread.sleep(2000);
		
		

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
