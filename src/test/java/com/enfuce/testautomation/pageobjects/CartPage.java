package com.enfuce.testautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Continue Shopping')]")
    private WebElement continueShopping;

    @FindBy(xpath = "//a[contains(.,'CHECKOUT')]")
    private WebElement checkout;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage continueShopping() {
        continueShopping.click();
        return PageFactory.initElements(driver, LandingPage.class);
    }
}
