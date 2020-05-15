package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeRightClick {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	void rightClick() throws InterruptedException {

		Actions actions = new Actions(driver);
		WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));

		actions.contextClick(rightClickButton).build().perform();

		//Thread.sleep(500);

		driver.findElement(By.xpath("//span[text()='Copy']")).click();

		Thread.sleep(1500);

		driver.switchTo().alert().accept();

		//Thread.sleep(2000);

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
