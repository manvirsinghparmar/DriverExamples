package WebDriver.Example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Check_All_Links {

	List<WebElement> links;

	HttpURLConnection huc = null;

	String url = "";

	String homepage = "http://automationpractice.com/index.php";

	int responsecode = 200;

	WebDriver driver;

	@BeforeMethod
	void setup() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(homepage);

		links = driver.findElements(By.tagName("a"));

	}

	@Test
	void checkAllLinks() {

		Iterator<WebElement> li = links.iterator();

		url = li.next().getAttribute("href");

		System.out.println(url);

		while (li.hasNext()) {

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");

				continue;
			}

			if (!url.startsWith(homepage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				responsecode = huc.getResponseCode();

				if (responsecode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@AfterMethod
	void tearDown() {

		driver.quit();
	}

}
