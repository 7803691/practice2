package com.kdv.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.DriverManager;


public class FunctionalTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        DriverManager.getInstance().setupDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
