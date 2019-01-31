package com.enfuce.testautomation.pageobjects;

import org.openqa.selenium.*;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }

    public boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
