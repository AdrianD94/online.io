package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginModel;
import models.RegisterModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by casab on 11/2/2017.
 */
public class RegisterTest extends BaseTestLogin {

    @DataProvider(name = "RegisterJson")
    public Iterator<Object[]> jsonLoginDataProvider() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Object[]> dp = new ArrayList<>();

        File[] files = getListOfFiles("registerJson");
        for (File f : files) {
            RegisterModel m = objectMapper.readValue(f, RegisterModel.class);
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "RegisterJson",priority=2)
    public void HappyFlowRegisterTest(RegisterModel registerModel) throws InterruptedException, AWTException {
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.HappyRegisterFlow(registerModel);

    }

    /*@Test(dataProvider = "RegisterJson",priority=1)
    public void BadloginFlowTest(LoginModel loginModel) throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.BadLoginFlow(loginModel);


    }*/

}
