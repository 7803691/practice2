package com.kdv.tests;

import pages.FirstPage;
import pages.LoginPage;
import pages.TweetPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest extends FunctionalTest {

    private FirstPage firstPage;

    @BeforeMethod
    public void setUpLogin() {
        driver.get("https://twitter.com");
    }

    @Test(dataProvider = "dataForLogin",dataProviderClass = DataForTest.class)
    public void login(String login, String password){
        firstPage = new FirstPage(driver);
        LoginPage loginPage =firstPage.clickOnLogin();
        loginPage.typeUserName(login);
        loginPage.typePassword(password);

        TweetPage tweetPage = loginPage.submitLogin();
        //System.out.println(driver.getTitle());
        Assert.assertEquals("Twitter",driver.getTitle());

        firstPage = tweetPage.logout();
    }

}
