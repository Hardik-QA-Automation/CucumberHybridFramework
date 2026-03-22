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

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeBrowser(String browserName) {

		boolean isCI = System.getenv("CI") != null;

		switch (browserName.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
			// 🔥 Always safer to use these flags in CI/Linux
			chromeOptions.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu",
					"--window-size=1920,1080", "--remote-allow-origins=*");
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();

			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
			driver.set(new EdgeDriver(edgeOptions));
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		// Common settings
		driver.get().manage().deleteAllCookies();
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver.get();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}