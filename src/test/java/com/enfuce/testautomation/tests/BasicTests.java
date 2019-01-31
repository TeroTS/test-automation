package com.enfuce.testautomation.tests;

import com.enfuce.testautomation.pageobjects.CartPage;
import com.enfuce.testautomation.pageobjects.LoginPage;
import com.enfuce.testautomation.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;


public class BasicTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setup() {
        driver = TestUtils.driverSetup("chrome");
        loginPage = PageFactory.initElements(driver, LoginPage.class).open();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginAndSelectItemTest() {
        // code here
        assertTrue();
        assertTrue();
    }

}
