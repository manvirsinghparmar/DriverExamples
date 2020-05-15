package WebDriver.Example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Firefox_Alerts_PopUps {

	WebDriver driver;

	@BeforeClass
	void Setup() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	void firstJavaScriptAlertBox() throws InterruptedException {

		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		System.out.println("The alert text is : " + alertText);

		alert.accept();

		Thread.sleep(1000);

	}

	@Test(priority = 2)
	void secondJavaScriptAlertBox() throws Exception {

		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
		
		
		driver.switchTo().activeElement();
		
		//This test is pending till further studies
		
		
	

	}

	@AfterClass
	void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}

}
