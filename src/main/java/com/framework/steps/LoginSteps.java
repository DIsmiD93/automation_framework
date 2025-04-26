package com.framework.steps;

import com.framework.pages.selenium.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final LoginPage loginPage;
    private static final String LOGIN_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com";

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }
   @Step("Login with email: {email} and password: {password}")
    public void loginWithEmailAndPassword(String email, String password){
        loginPage.inputDataToEmailField(email);
        loginPage.inputDataToPasswordField(password);
        loginPage.clickSubmitButton();
    }
    @Step("Login with email: {email} only")
    public void loginWithEmailOnly(String email){
        loginPage.inputDataToEmailField(email);
        loginPage.clickSubmitButton();
    }
    @Step("Login with password: {password} only")
    public void loginWithPasswordOnly(String password){
        loginPage.inputDataToPasswordField(password);
        loginPage.clickSubmitButton();
    }
   @Step("Get login Error message")
    public String getLoginErrorMessage(){
        return loginPage.getLoginErrorMessage();
    }
    @Step("Open Login Page")
    public void openLoginPage(){
        loginPage.open(LOGIN_PAGE_URL);
    }
}