package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;

	public static WebDriver initializeBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();

		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

        ChromeOptions options = new ChromeOptions();

        // Required for GitHub Linux runners
        options.addArguments("--headless=new");        // Run headless
        options.addArguments("--no-sandbox");          // Disable sandbox
        options.addArguments("--disable-dev-shm-usage");// Avoid limited /dev/shm
        options.addArguments("--disable-gpu");         // Disable GPU
        options.addArguments("--window-size=1920,1080"); // Set window size

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver;

	}

	public static WebDriver getDriver() {

		return driver;
	}

}
