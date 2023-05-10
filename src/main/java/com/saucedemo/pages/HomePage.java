package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//span[@class='title']")
    WebElement productMessage;

    By listOfProduct = By.xpath("//div[@class='inventory_item']");

    // This method is to get product message and return the text message.
    public String getProductMessage() {
        Reporter.log("Get the Product message "+ productMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get Product Message "+ productMessage);
        return getTextFromElement(productMessage);
    }

    // This method is for getting the product quantity Displayed on homepage
    public int numberOfProductDisplayed() {
        Reporter.log("Get number of Product displayed "+ listOfProduct.toString());
        CustomListeners.test.log(Status.PASS, "Get the number of product displayed "+ listOfProduct);
        List<WebElement> product = driver.findElements( listOfProduct);
        return product.size();

    }
}
