package WebDriver.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(Listener.class)
public class Carbonite {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void Setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.carbonite.com/backup-software/safe-personal-trial/");

		driver.manage().window().maximize();
	}

	@Test
	void selectTest() {

		WebElement element = driver.findElement(By.xpath("//select[@name='Country']"));

		element.click();

		Select s = new Select(element);

		s.selectByVisibleText("Sweden");

		WebElement selectedValue = s.getFirstSelectedOption();

		String actualValue = selectedValue.getText();

		Assert.assertEquals(actualValue, "Sweden", "Actual Value Found");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void validEmailTest() {

		WebElement confirmEmail = driver.findElement(By.xpath("//input[@type='email' and @name='Email']"));

		confirmEmail.sendKeys("manvir@123.com");

		WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Must be valid email')]"));

		wait.until(ExpectedConditions.visibilityOf(errorMessage));

		Assert.assertEquals(errorMessage.getText(), "Must be valid email");

	}

	@Test
	void validateBorderColorForWrongInput() {

		WebElement passwordInputBox = driver.findElement(By.xpath("//input[@name='Password']"));

		passwordInputBox.sendKeys("Naam");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String rgbValue = passwordInputBox.getCssValue("border-bottom-color");

		String color = Color.fromString(rgbValue).asHex();

		Assert.assertEquals(color, "#843534");

	}

	@AfterMethod
	void tearDown() {

		try {
			System.out.println("Closing Browser");
		} finally {
			driver.quit();
		}
	}

}
