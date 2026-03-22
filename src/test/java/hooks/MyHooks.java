package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {

	@Before
	public void setup() {
		new ConfigReader();
		Properties prop = ConfigReader.initializeProperties();

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		// Initialize driver
		WebDriver driver = DriverFactory.initializeBrowser(browser);

		if (driver == null) {
			throw new RuntimeException("WebDriver initialization failed for browser: " + browser);
		}
		// Navigate to URL
		driver.get(url);
	}

	@After
	public void tearDown(Scenario scenario) {

		WebDriver driver = DriverFactory.getDriver(); // Always get from factory
		if (driver != null) {
			try {
				// Take screenshot only if scenario failed
				if (scenario.isFailed()) {
					byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/png", scenario.getName().replaceAll(" ", "_"));
				}
			} catch (Exception e) {
				System.out.println("Screenshot failed: " + e.getMessage());
			} finally {
				DriverFactory.quitDriver(); // clean shutdown
			}
		} else {
			System.out.println("Driver is null in tearDown()");
		}
	}
}