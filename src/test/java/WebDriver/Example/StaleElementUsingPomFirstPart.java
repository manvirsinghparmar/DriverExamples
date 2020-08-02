package WebDriver.Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementUsingPomFirstPart extends Base {
	
	
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public StaleElementUsingPomFirstPart() {

		System.out.println("Inside Constructor of SF1 and page factory has not been executed");

		PageFactory.initElements(driver, this);

		System.out.println("Inside Constructor of SF1 and page factory has been executed");

	}

	@FindBy(id = "searchIcon")
	WebElement searchIcon;

	@FindBy(id = "btn-VSB-trial")
	WebElement freeTrialButton;

	public String clickSearchIcon() {

		System.out.println("Inside Send Text");

		

		wait.until(ExpectedConditions.visibilityOf(searchIcon));

		driver.navigate().refresh();

		searchIcon.click();

		String titloFPage = driver.getTitle();

		System.out.println("Title of Page : " + titloFPage);

		return titloFPage;
	}

	public String clickFreeTrialButton() {

		freeTrialButton.click();

		String titleofTrialPage = driver.getTitle();

		driver.navigate().back();

		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.elementToBeClickable(freeTrialButton));

		String textOfFreeTrial = freeTrialButton.getTagName();

		return textOfFreeTrial;

	}

}
