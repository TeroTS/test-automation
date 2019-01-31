package com.enfuce.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestUtils {

    public static Properties getProperties() {
        String env = System.getProperty("env");
        String file = String.format("env.%s.properties", env == null ? "local" : env);
        Properties properties = new Properties();
        InputStream input = TestUtils.class.getClassLoader().getResourceAsStream(file);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static WebDriver driverSetup(String browser) {
        if (browser.equals("chrome")) {
            Properties prop = getProperties();
            System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(Boolean.parseBoolean(prop.getProperty("isheadless")));
            options.addArguments("--no-sandbox");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("defaultwait")), TimeUnit.SECONDS);
            return driver;
        } else {
            throw new IllegalArgumentException("Browser: " + browser + " not supported!");
        }
    }

}
