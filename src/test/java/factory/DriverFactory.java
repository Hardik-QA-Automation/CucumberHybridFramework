package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;

	public static WebDriver initializeBrowser(String browserName) {
		
		ChromeOptions options = new ChromeOptions();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		EdgeOptions edgeOptions = new EdgeOptions();

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			  // Required for GitHub Linux runners
	        options.addArguments("--headless=new");        // Run headless
	        options.addArguments("--no-sandbox");          // Disable sandbox
	        options.addArguments("--disable-dev-shm-usage");// Avoid limited /dev/shm
	        options.addArguments("--disable-gpu");         // Disable GPU
	        options.addArguments("--window-size=1920,1080"); // Set window size

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
            firefoxOptions.addArguments("--headless");           // Headless mode
            firefoxOptions.addArguments("--window-size=1920,1080");
            driver = new FirefoxDriver(firefoxOptions);

		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
			edgeOptions.addArguments("--headless=new");         // Headless mode
            edgeOptions.addArguments("--disable-gpu");
            edgeOptions.addArguments("--window-size=1920,1080");
            driver = new EdgeDriver(edgeOptions);

		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

        

      

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
