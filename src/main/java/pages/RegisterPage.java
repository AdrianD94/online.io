package pages;
import models.LoginModel;
import models.RegisterModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
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

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'I accept')]")
    private WebElement iAgree;

    public void HappyRegisterFlow(RegisterModel registerModel) throws InterruptedException, AWTException {
        Robot r=new Robot();
        WebDriverWait wait=new WebDriverWait(driver,200);

        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOf(closeChat));
        //closeChat.click();
        wait.until(ExpectedConditions.visibilityOf(continueButton));



        //r.keyPress(KeyEvent.VK_ENTER);

        //
        //
         continueButton.click();

         wait.until(ExpectedConditions.visibilityOf(firstNameInput));

         firstNameInput.sendKeys(registerModel.getFirstName());
         wait.until(ExpectedConditions.textToBePresentInElementValue(firstNameInput,registerModel.getFirstName()));
         okButton.click();

        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.sendKeys(registerModel.getLastName());
        wait.until(ExpectedConditions.textToBePresentInElementValue(lastNameInput,registerModel.getLastName()));
        okButton.click();

        wait.until(ExpectedConditions.visibilityOf(countryInput));
        countryInput.sendKeys(registerModel.getCountry());
        wait.until(ExpectedConditions.textToBePresentInElementValue(countryInput,registerModel.getCountry()));
        okButton.click();
        //r.keyPress(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOf(userEmail));
        userEmail.sendKeys(registerModel.getEmail());
        wait.until(ExpectedConditions.textToBePresentInElementValue(userEmail,registerModel.getEmail()));
        okButton.click();

        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(registerModel.getPassword());
        wait.until(ExpectedConditions.textToBePresentInElementValue(passwordInput,registerModel.getPassword()));
        okButton.click();

        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput));
        confirmPasswordInput.sendKeys(registerModel.getConfirmPassword());
        wait.until(ExpectedConditions.textToBePresentInElementValue(confirmPasswordInput,registerModel.getConfirmPassword()));
        okButton.click();


        wait.until(ExpectedConditions.visibilityOf(chatMethod));
        Select dropdown=new Select(chatMethod);

        Thread.sleep(2000);
        chatMethod.click();
        dropdown.selectByVisibleText("Skype");
        wait.until(ExpectedConditions.visibilityOf(chatMethodInput));
        chatMethodInput.sendKeys(registerModel.getSkype());

        r.keyPress(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'How much would you like to contribute?')]"))));
        radioButton1.get(1).click();
        okButton.click();

       wait.until(ExpectedConditions.visibilityOf(iAgree));


        termsCondition.get(0).click();
        r.keyPress(KeyEvent.VK_ENTER);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(successScreen));
        Assert.assertTrue(successScreen.isDisplayed());


    }




}
