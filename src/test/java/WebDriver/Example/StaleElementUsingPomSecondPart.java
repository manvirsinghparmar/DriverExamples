package WebDriver.Example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class StaleElementUsingPomSecondPart extends Base {

	StaleElementUsingPomFirstPart sf1;

	@BeforeMethod
	void setup() {

		inialisation();

		driver.get("https://www.carbonite.com/");

		sf1 = new StaleElementUsingPomFirstPart();

	}

	@Test(priority = 1)
	void googleSearch() {

		String titleOfPage = sf1.clickSearchIcon();

		Assert.assertEquals(titleOfPage, "Search");
	}

	@Test(priority = 2)
	void clickFreeTrialButton() {

		String clickButtonTagName = sf1.clickFreeTrialButton();

		Assert.assertEquals(clickButtonTagName, "a");

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
