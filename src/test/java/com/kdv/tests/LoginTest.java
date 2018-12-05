package com.kdv.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.LoginPage;
import pages.TweetPage;
import utils.PropertyManager;


public class LoginTest extends FunctionalTest {

    private FirstPage firstPage;
    private LoginPage loginPage;


    @BeforeMethod
    public void setUpLogin() {
        driver.get(PropertyManager.getInstance().getUrl());
    }


    @Test(dataProvider = "dataForLogin",dataProviderClass = DataForTest.class)
    public void login(String login, String password){

        firstPage = new FirstPage(driver);

        loginPage =firstPage.clickOnLogin();

        loginPage.typeUserName(login);

        loginPage.typePassword(password);

        TweetPage tweetPage = loginPage.submitLogin();

        Assert.assertEquals("Twitter",driver.getTitle());

        firstPage = tweetPage.logout();
    }


}
