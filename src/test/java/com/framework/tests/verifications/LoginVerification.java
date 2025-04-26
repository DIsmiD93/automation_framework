package com.framework.tests.verifications;

import com.framework.steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginVerification {
    LoginSteps loginSteps;

    public LoginVerification(WebDriver webdriver) {
        this.loginSteps = new LoginSteps(webdriver);
    }

    public void verifyIncorrectLoginMessage(String expectedMessage) {
        Assert.assertEquals(loginSteps.getLoginErrorMessage(),expectedMessage,
                "Error. Incorrect login message is nt as expected");
    }
}
