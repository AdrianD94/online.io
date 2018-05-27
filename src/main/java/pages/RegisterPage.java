package pages;
import models.RegisterModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }


    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Sign Up')]")
    private WebElement signUpButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Continue')]")
    private WebElement continueButton;

    @FindBy(how = How.ID, using = "user-first-name")
    private WebElement firstNameInput;

    @FindBy(how = How.ID, using = "user-last-name")
    private WebElement lastNameInput;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Ok')]")
    private WebElement okButton;



    @FindBy(how = How.ID, using = "user-country")
    private WebElement countryInput;

    @FindBy(how = How.ID, using = "user-email")
    private WebElement userEmail;

    @FindBy(how = How.ID, using = "user-password")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "user-password-confirm")
    private WebElement confirmPasswordInput;

    @FindBy(how = How.ID, using = "chat-method")
    private WebElement chatMethod;

    @FindBy(how = How.ID, using = "chat-id")
    private WebElement chatMethodInput;

    @FindBy( how = How.CLASS_NAME, using = "form-check-label ")
    private List<WebElement> radioButton1;

    @FindBy( how = How.ID, using = "agreement")
    private List<WebElement> termsCondition;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Submit')]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Online.io TGE')]")
    private WebElement successScreen;

    @FindBy(how = How.XPATH, using = "//*[@id=\"intercom-container\"]/div/span[2]/div/div/a")
    private WebElement closeChat;



    public void HappyRegisterFlow(RegisterModel registerModel) throws InterruptedException, AWTException {
        Robot r=new Robot();
        WebDriverWait wait=new WebDriverWait(driver,20);

        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();


        wait.until(ExpectedConditions.visibilityOf(closeChat));
        closeChat.click();
        wait.until(ExpectedConditions.visibilityOf(continueButton));



        //okButton.click();

        //
        //
        driver.navigate().refresh();
         continueButton.click();

        Thread.sleep(5000);

        //okButton.click();




        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.click();
       // firstNameInput.clear();

        //
         //okButton.click();
       // okButton.click();
       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Please fill this in')]")).isDisplayed());
        firstNameInput.sendKeys(registerModel.getFirstName());

        okButton.click();




        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        //lastNameInput.clear();
        //okButton.click();
        //Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Please fill this in')]")).isDisplayed());
        lastNameInput.sendKeys(registerModel.getLastName());
        okButton.click();



        wait.until(ExpectedConditions.visibilityOf(countryInput));
       // countryInput.clear();
       // okButton.click();
       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Please fill this in')]")).isDisplayed());
        countryInput.sendKeys(registerModel.getCountry());
        okButton.click();



        wait.until(ExpectedConditions.visibilityOf(userEmail));
        //userEmail.clear();
       // Thread.sleep(1000);
        //okButton.click();
        //Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Please enter valid email address')]")).isDisplayed());
        //userEmail.sendKeys("dsadsadsa");

      //  okButton.click();
       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Please enter valid email address')]")).isDisplayed());
       // userEmail.clear();
        userEmail.sendKeys(registerModel.getEmail());

        okButton.click();



        wait.until(ExpectedConditions.visibilityOf(passwordInput));
       // passwordInput.clear();
      //  Thread.sleep(1000);
       // okButton.click();
       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Use numbers, upper, lower case letters, special chars')]")).isDisplayed());
       // passwordInput.sendKeys("dsadsadsa");
       // Thread.sleep(1000);
       // okButton.click();
      //  Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Use numbers, upper, lower case letters, special chars')]")).isDisplayed());
      //  passwordInput.clear();
        passwordInput.sendKeys(registerModel.getPassword());
       // Thread.sleep(1000);
        okButton.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


     //   wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput));
     //   confirmPasswordInput.clear();
      //  okButton.click();
      //  Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Password does not match')]")).isDisplayed());
        //confirmPasswordInput.clear();
        //confirmPasswordInput.sendKeys("dsadasda");
        //okButton.click();
       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Password does not match')]")).isDisplayed());
       // confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(registerModel.getConfirmPassword());
        okButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        wait.until(ExpectedConditions.visibilityOf(chatMethod));
        Select dropdown=new Select(chatMethod);


        chatMethod.click();
        dropdown.selectByVisibleText("Skype");
        wait.until(ExpectedConditions.visibilityOf(chatMethodInput));
        chatMethodInput.sendKeys(registerModel.getSkype());

        okButton.click();

        Thread.sleep(5000);
        radioButton1.get(1).click();
        okButton.click();

        Thread.sleep(9000);

        termsCondition.get(0).click();
        okButton.click();
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(successScreen));
        Assert.assertTrue(successScreen.isDisplayed());


    }




}
