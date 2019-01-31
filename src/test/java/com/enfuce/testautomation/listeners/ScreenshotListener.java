package com.enfuce.testautomation.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Paths;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Class clazz = result.getTestClass().getRealClass();
        try {
            Field field = clazz.getDeclaredField("driver");
            field.setAccessible(true);
            WebDriver driver = (WebDriver) field.get(result.getInstance());
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String reportDirectory = Paths.get(".").toAbsolutePath().toString() + "/build/testng-output/";
            File destFile = new File( reportDirectory +  result.getMethod().getMethodName() + "_scrnshot.png");
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("<a href='"+ destFile.getName() + "'> <img src='"+ destFile.getName() + "' height='100' width='100'/> </a>");
        } catch (NoSuchFieldException|IllegalAccessException|IOException e) {
            e.printStackTrace();
        }
    }

}
