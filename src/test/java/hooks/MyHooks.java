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

    private WebDriver driver;

    @Before
    public void setup() {
        // Load configuration
        Properties prop = new ConfigReader().initializeProperties();
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        // Initialize WebDriver using DriverFactory
        driver = DriverFactory.initializeBrowser(browser);

        if (driver == null) {
            throw new RuntimeException("WebDriver initialization failed for browser: " + browser);
        }

        // Navigate to the application URL
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
        driver = DriverFactory.getDriver(); // always get the current driver

        if (driver != null) {
            try {
                // Capture screenshot if the scenario failed
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName().replaceAll(" ", "_"));
                }
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            } finally {
                // Quit and clean up driver
                DriverFactory.quitDriver();
            }
        }
    }
}
