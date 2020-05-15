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

public class Firefox_Slider {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");

	}

	@Test(priority = 1)
	void Slider() throws InterruptedException {
		
		Actions act=new Actions(driver);

		WebElement sliderElement=driver.findElement(By.xpath("//input[@type='range' and @onchange='range.value=value']"));
		
		
		act.moveToElement(sliderElement).dragAndDropBy(sliderElement, 40, 0).build().perform();
		
		
		

	}

	

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
