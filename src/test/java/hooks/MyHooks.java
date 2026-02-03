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

	WebDriver driver;

	@Before
	public void setup() {

		Properties prop = new ConfigReader().initializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));

		if (driver == null) {
			throw new RuntimeException("WebDriver initialization failed");
		}

		driver.get(prop.getProperty("url"));
	}
    @After
    public void tearDown(Scenario scenario) {
        // Get driver from DriverFactory
        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            try {
                // Attach screenshot if scenario failed
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                }
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            } finally {
                // Quit driver safely
                DriverFactory.quitDriver();
            }
        }
    }
}
