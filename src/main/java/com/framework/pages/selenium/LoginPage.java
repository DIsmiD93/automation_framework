package com.framework.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(css = "[id='submit']")
    private WebElement submitButton;

    // //*[text()='Incorrect username or password'] - Find Using text full match
    // //*[contains(text(), 'Incorrect')] - Find Using text partial match
    @FindBy(xpath = "//*[@id='error']")
    private WebElement loginErrorMessage;

    public void inputDataToEmailField(String email) {
        emailInputField.sendKeys(email);
    }

    public void inputDataToPasswordField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getLoginErrorMessage(){
        waitForElementToBeDisplayed(loginErrorMessage);
        return loginErrorMessage.getText();
    }
}
