package com.framework.verifications;

import com.framework.steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginVerification {
    LoginSteps loginSteps;

    public LoginVerification(WebDriver webdriver) {
        this.loginSteps = new LoginSteps(webdriver);
    }

    public void verifyIncorrectLoginMessage(String message) {
      Assert.
    }
}
