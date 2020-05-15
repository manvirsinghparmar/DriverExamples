package WebDriver.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox_DragDrop {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		driver.manage().window().maximize();

		

	}

	@Test(priority = 1)
	void DragDrop() throws InterruptedException {

		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='box2']"));

		WebElement destinationElement = driver.findElement(By.xpath("//div[@id='box105']"));

		Actions action = new Actions(driver);

		//action.clickAndHold(sourceElement).moveToElement(destinationElement).release().build().perform();
		
		action.dragAndDrop(sourceElement, destinationElement).build().perform();
		
		
	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
