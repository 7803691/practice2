package com.kdv.tests;

import org.testng.Assert;
import pages.FirstPage;
import pages.LoginPage;
import utils.PageLoadCondition;
import pages.TweetPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TweetWithImage extends FunctionalTest {

    private FirstPage firstPage;

    @BeforeMethod
    public void setUpTweetWithImage() {
        driver.get("https://twitter.com/login");
    }

    @Test(dataProvider = "dataForTweetWithImage", dataProviderClass = DataForTest.class)
    public void testTweetWithImage(String login, String password, String message, String pathToFile) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(login);
        loginPage.typePassword(password);
        TweetPage tweetPage = loginPage.submitLogin();

        //Call function for waiting page complete loaded
        PageLoadCondition.waitForLoad(driver);
        System.out.println(tweetPage.getCountOfTwitts());
        tweetPage.writeTweetWithImage(message,pathToFile);

        Assert.assertTrue(tweetPage.imagePresntInTwitt());
        System.out.println(tweetPage.getCountOfTwitts());
        firstPage = tweetPage.logout();

    }


}
