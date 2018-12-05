package com.kdv.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.DriverManager;
import utils.Log;
import utils.ScreenShot;


public class FunctionalTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
       driver = DriverManager.getInstance().getDriver();
       DriverManager.getInstance().setUpDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenShot.takeScreenShot(driver, result.getName());
        }
    }


    @AfterClass
    public void tearDown(){
        Log.debug(driver + "Close");
        DriverManager.getInstance().quit();
    }


}
