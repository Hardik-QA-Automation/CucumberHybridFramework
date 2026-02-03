package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonUtils;

public class DriverFactory {

//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeBrowser(String browserName) {
		
		boolean isCI = System.getenv("CI") != null;

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			if (isCI) {
				options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu",
						"--window-size=1920,1080");
			}

			driver.set(new ChromeDriver(options));

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (isCI) {
				firefoxOptions.addArguments("--headless");
				firefoxOptions.addArguments("--width=1920");
				firefoxOptions.addArguments("--height=1080");
			}

			driver.set(new FirefoxDriver(firefoxOptions));

		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			if (isCI) {

				edgeOptions.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
			}

			driver.set(new EdgeDriver(edgeOptions));

		} else {
			throw new IllegalArgumentException("Browser not supported: " + browserName);
		}

		driver.get().manage().deleteAllCookies();
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver.get();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	// Quit and remove driver from ThreadLocal
	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // important!
		}
	}
}