package common.functions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static WebDriver createDriver() throws Exception {
		ReadExcel ex = new ReadExcel();
		String remote = ex.getConfigData("Remote");
		String version = ex.getConfigData("Version");
		String seleniumHub = ex.getConfigData("Selenium Hub");
		String browser = ex.getConfigData("Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver;
		if (remote.toLowerCase().equals("false")){
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			default:
				driver = new FirefoxDriver();
				break;
			}
		}
		else {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			URL SeleniumGridURL = new URL(seleniumHub);
	        capabilities.setBrowserName(browser);
	        capabilities.setPlatform(Platform.WINDOWS);
	        capabilities.setVersion(version);
	        driver = new RemoteWebDriver(SeleniumGridURL, capabilities);	
		}

		return driver;

	}

}
