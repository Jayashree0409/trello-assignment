package nl.knab.trello.ui.steps;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Selenium WebDriver to load the webpages
 */
public class Hooks {

	private static Logger Log = Logger.getLogger(Hooks.class.getName());

	public static WebDriver driver;

	@Before
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Log.info("ChromeDriver loaded successfully");
	}

	@After
	public void tearDown(Scenario scenario) {

		try {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			if (scenario.isFailed()) {
				scenario.log("this is my failure message");
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
		} catch (Exception e) {

			Log.error("Exception occured while loading driver :" + e);
		}
		driver.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
