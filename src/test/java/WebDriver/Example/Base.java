package WebDriver.Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;

	public void inialisation() {

		

		

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

	}

}
