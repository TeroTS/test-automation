package com.enfuce.testautomation.pageobjects;

import com.enfuce.testautomation.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final static String LOGINGPAGE_URL = TestUtils.getProperties().getProperty("baseurl");

    // add this
    @FindBy(id = "")
    private WebElement userIdField;

    // add this
    @FindBy(id = "")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'LOGIN')]")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(LOGINGPAGE_URL);
        return this;
    }

    public LandingPage login(String userId, String password) {
        // code here
        return PageFactory.initElements(driver, LandingPage.class);
    }

}


