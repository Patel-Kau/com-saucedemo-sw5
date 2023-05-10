package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void init(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter the user in email field
        loginPage.enterEmailId("standard_user");

        // Enter the Password in Password field
        loginPage.enterPassword("secret_sauce");

        // Click on the Login Button
        loginPage.clickOnLoginButton();

        // Expected message
        String expectedProductMessage = "Products";

        // Wait until Element is displayed
        waitUntilVisibilityOfElementLocated(By.xpath("//span[@class='title']"), 5);

        // Get the actual text form the home page
        String actualProductMessage = homePage.getProductMessage();

        // Verify the expected message with actual message
        Assert.assertEquals(actualProductMessage, expectedProductMessage);
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter the user in email field
        loginPage.enterEmailId("standard_user");

        // Enter the Password in Password field
        loginPage.enterPassword("secret_sauce");

        // Click on the Login Button
        loginPage.clickOnLoginButton();

        // Get the actual product quantity form the home page
        int actualQuantity = homePage.numberOfProductDisplayed();

        // Exacted quantity
        int expectedQuantity = 6;

        // Verify the expected quantity with actual quantity
        Assert.assertEquals(expectedQuantity, actualQuantity);

    }

}
