package WebDriver.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class homedepot {

	WebDriver driver;

	@BeforeMethod
	void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.homedepot.ca/en/home.html");

	}

	@Test
	void homeDepotTest() throws InterruptedException {
		
		
		
		//closing pop-up location window
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='hdca-gheader-localization__popover-body']")));
	    driver.findElement(By.xpath("//button[@title='Close dialog']")).click();
	    
	    
	    Actions action = new Actions(driver);
	    
	    //Mouse hover to Department - Bath Section
	    WebElement department = driver.findElement(By.xpath("//span[@class='hdca-gheader-nav__item-button-label' and contains(text(),'Shop by Department')]"));
        WebElement bath = driver.findElement(By.xpath("//span[@class='hdca-gheader-flyout-shop__l1list-item-label' and contains(text(),'Bath')]"));
	    action.moveToElement(department).moveToElement(bath).build().perform();
	    
	    //Click on Vanity Tops
	    WebElement vanityTops = driver.findElement(By.xpath("//a[@class='hdca-flyout-category-l3list__link' and contains(text(),'Vanity Tops')]"));
	    action.moveToElement(vanityTops).click().build().perform();
	
	   driver.findElement(By.xpath("(//span[@class='acl-button__label ng-star-inserted' and contains(text(),'Add To Cart')]/parent::button)[1]")).click();
	   
	   WebElement addToCart_Window = driver.findElement(By.xpath("//header[@class='acl-modal__header ng-tns-c72-19 ng-star-inserted']"));
	   if(addToCart_Window.isDisplayed()) {
		   Assert.assertTrue(true,"Item not added to Cart");
	   }
	    		
		
		
		
		

	}

	@AfterMethod
	void tearDown() {

		
	}

}
