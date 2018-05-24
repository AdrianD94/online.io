package tests;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by casab on 11/2/2017.
 */
    public class WebBrowsers {
        public static WebDriver getDriver(Browsers browserName) {
            WebDriver driver = null;

            switch (browserName) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/gekodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Unknown browser: " + browserName);
            }
            return driver;
        }
    }

