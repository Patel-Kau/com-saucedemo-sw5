package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    public void enterEmailId(String email) {
        Reporter.log("Enter EmailId " + emailField.toString());
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + emailField);
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password "+ passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password "+ passwordField );
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton() {
        Reporter.log("Click on Log in button"+ loginButton.toString());
        CustomListeners.test.log(Status.PASS,"Click on Login Button" + loginButton);
        clickOnElement(loginButton);

    }


}