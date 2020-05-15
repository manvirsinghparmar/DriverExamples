package WebDriver.Example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Nimisha_program {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\WebdriverExample\\drivers\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		if(driver.findElement(By.className("at4win-header")).isDisplayed()){
			driver.findElement(By.id("at-cv-lightbox-close")).click();	
		}
		driver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//a[text()='Input Forms']")).click();
		driver.findElement(By.xpath("//li[@class='tree-branch']//ul//li//ul//li//a[text()='Select Dropdown List']")).click();

		String ExpTitle = "Selenium Easy Demo - Automate All Scenarios";
		Assert.assertEquals(driver.getTitle(), ExpTitle,"select drop down demo page not opened");


		// url - https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html

		// selecting multiple elements from drop down
		Select select = new Select(driver.findElement(By.id("multi-select")));
		String[] cities = { "California" , "Ohio" ,"Pennsylvania"};
		for(int i=0;i<cities.length;i++) {
			select.selectByVisibleText(cities[i]);
		}


		// printing all the selected options
		System.out.println("first selected : " + select.getFirstSelectedOption().getText());

		List <WebElement> selected = select.getAllSelectedOptions();
		for(WebElement ele : selected) {
			
			Thread.sleep(6000);
			System.out.println(">>> " + ele.getText());
		}

		// clicking on get all selected button
		//Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='Get All Selected']")).click();
        String allSelected = driver.findElement(By.className("getall-selected")).getText();
		System.out.println("on web page : " + allSelected);
		
		
		
		
	}
	
	

}
