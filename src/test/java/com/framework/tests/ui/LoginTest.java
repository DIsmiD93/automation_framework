package com.framework.tests.ui;

import com.framework.drivers.DriverManager;
import com.framework.steps.LoginSteps;
import com.framework.tests.listeners.AllureListener;
import com.framework.tests.verifications.LoginVerification;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.*;

@Feature("Login test suite")
public class LoginTest extends BaseTest {
    private LoginSteps loginSteps;
    private LoginVerification loginVerification;
    private static final String INCORRECT_LOGIN_MESSAGE = "Incorrect username or password";

    @BeforeMethod
    public void initStepsAndVerifications() {
        loginSteps = new LoginSteps(DriverManager.getDriver());
        loginVerification = new LoginVerification(DriverManager.getDriver());
    }

    @Test(description = "Verify login failed with wrong email and password")
    @Description("User should see error message when entering wrong email and password.")
    public void verifyLoginFailedWithWrongEmailAndPassword() {
        loginSteps.openLoginPage();
        loginSteps.loginWithEmailAndPassword("some@email.com", "1234");
        loginVerification.verifyIncorrectLoginMessage(INCORRECT_LOGIN_MESSAGE);
    }

    @Test(description = "Verify wrong message after login failed with wrong email and password")
    public void verifyLoginFailedWithWrongEmailAndPasswordWrongMessage() {
        loginSteps.openLoginPage();
        loginSteps.loginWithEmailAndPassword("some@email.com", "1234");
        loginVerification.verifyIncorrectLoginMessage("wrong message");
    }
}
