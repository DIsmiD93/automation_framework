package com.framework.tests.ui;

import com.framework.drivers.DriverManager;
import com.framework.steps.LoginSteps;
import com.framework.tests.verifications.LoginVerification;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{
    private LoginSteps loginSteps;
    private LoginVerification loginVerification;
    private static final String INCORRECT_LOGIN_MESSAGE = "Incorrect username or password";

    @BeforeMethod
    public void initStepsAndVerifications(){
        loginSteps = new LoginSteps(DriverManager.getDriver());
        loginVerification = new LoginVerification(DriverManager.getDriver());
    }

    @Test
    public void verifyLoginFailedWithWrongEmailAndPassword() {
        loginSteps.openLoginPage();
        loginSteps.loginWithEmailAndPassword("some@email.com", "1234");
        loginVerification.verifyIncorrectLoginMessage(INCORRECT_LOGIN_MESSAGE);
    }
}
