package tests;

import enums.Browsers;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by casab on 11/2/2017.
 */
    public class WebBrowsers {
        public static WebDriver getDriver(Browsers browserName) {
            WebDriver driver = null;

            switch (browserName) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new ChromeDriver(capabilities);
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                    FirefoxOptions FFoptions = new FirefoxOptions();
                    FFoptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed

                    DesiredCapabilities FFcapabilities = DesiredCapabilities.firefox();
                    FFcapabilities.setCapability("moz:firefoxOptions", FFoptions);
                    //set more capabilities as per your requirements


                    driver = new FirefoxDriver(FFcapabilities);

                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;

                case EDGE:
                    System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Unknown browser: " + browserName);
            }
            return driver;
        }
    }

