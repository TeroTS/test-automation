package com.enfuce.testautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    // add this
    @FindBy(xpath = "")
    private WebElement addToCartButton;

    // add this
    @FindBy(id = "")
    private WebElement viewCartButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage addTheFirstItemToCart() {
        // code here
        return this;
    }

    public LandingPage addItemByName(String name) {
        String locator = String.format("//div[contains(.,'%s')]/*/button", name);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    public CartPage goToCartPage() {
        // code here
        return PageFactory.initElements(driver, CartPage.class);
    }

}
