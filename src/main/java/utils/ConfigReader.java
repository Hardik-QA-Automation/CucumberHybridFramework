package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public ConfigReader() {
	}

	public static Properties initializeProperties() {
		if (prop == null) {
			prop = new Properties();
			// load file
			try {
				// Path to your properties file
				FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
				prop.load(ip);
			} catch (Exception e) {
				throw new RuntimeException("Failed to load config file", e);
			}
		}
		return prop;
	}
}
