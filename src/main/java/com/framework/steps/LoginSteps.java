package com.framework.steps;

import com.framework.pages.selenium.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final LoginPage loginPage;
    private static final String LOGIN_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com";

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void loginWithEmailAndPassword(String email, String password){
        loginPage.inputDataToEmailField(email);
        loginPage.inputDataToPasswordField(password);
        loginPage.clickSubmitButton();
    }

    public void loginWithEmailOnly(String email){
        loginPage.inputDataToEmailField(email);
        loginPage.clickSubmitButton();
    }

    public void loginWithPasswordOnly(String password){
        loginPage.inputDataToPasswordField(password);
        loginPage.clickSubmitButton();
    }

    public String getLoginErrorMessage(){
       return loginPage.getLoginErrorMessage();
    }

    public void openLoginPage(){
        loginPage.open(LOGIN_PAGE_URL);
    }
}
