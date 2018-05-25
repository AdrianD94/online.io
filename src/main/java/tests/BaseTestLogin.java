package tests;

import enums.Browsers;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by casab on 11/2/2017.
 */
public class BaseTestLogin {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebBrowsers.getDriver(Browsers.CHROME);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://online.io");
        //https://d1qoal4nguj436.cloudfront.net/sign-up

        Thread.sleep(1000);
    }


    public void quit() {
        driver.quit();
    }

    File[] getListOfFiles(String directoryName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(classLoader.getResource(directoryName).getFile());
        File[] files = directory.listFiles();
        // System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException{
        driver.quit();
    }
}
