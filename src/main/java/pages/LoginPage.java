package pages;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest test;
    public LoginPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }

    @FindBy(how = How.CLASS_NAME, using = "src-components-Layout-Header-___header-styles__header-logo___1m-W1")
    private WebElement onlineLogo;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    @FindBy(how = How.ID, using = "user-login-email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "user-login-password")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(how = How.CLASS_NAME, using = "src-pages-Home-___home-styles__welcome___v2U64")
    private WebElement loginSuccessScreen;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Wrong email or password')]")
    private WebElement loginValidationError;



    public void HappyLoginFlow(LoginModel model) throws InterruptedException {
        reports = new ExtentReports(System.getProperty("user.dir") + "/HtmlReport/index.html", true);
        test = reports.startTest("Happy Flow Login Test", "Validate user can log in using valid credentials");
        test.log(LogStatus.PASS,"Browser launch successful");
        test.log(LogStatus.PASS,"Successfully navigate to online.io");
        WebDriverWait wait=new WebDriverWait(driver,20);

        //--------------Happy flow--------------------
        //wait.until(ExpectedConditions.visibilityOf(onlineLogo));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(model.getEmailAddress());
        passwordField.clear();
        passwordField.sendKeys(model.getPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginSuccessScreen));
        Assert.assertEquals(driver.getCurrentUrl(),"https://d1qoal4nguj436.cloudfront.net/");

    }

    public void BadLoginFlow(LoginModel model) throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver,10);
        //--------------Bad flow--------------------
        //----Wrong Email & Password-----------
        //wait.until(ExpectedConditions.visibilityOf(onlineLogo));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(model.getBadEmail());
        passwordField.click();
        passwordField.sendKeys(model.getBadPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginValidationError));
        Assert.assertTrue(loginValidationError.isDisplayed());


        //----Good Email & Bad Password-----------

         wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(model.getEmailAddress());
        passwordField.click();
        passwordField.sendKeys(model.getBadPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginValidationError));
        Assert.assertTrue(loginValidationError.isDisplayed());



        //Bad email & Good Password

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(model.getBadEmail());
        passwordField.click();
        passwordField.sendKeys(model.getPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginValidationError));
        Assert.assertTrue(loginValidationError.isDisplayed());

    }

}
