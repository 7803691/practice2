package com.kdv.tests;

import pages.LoginPage;
import pages.ReTweetPage;
import pages.TweetPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReTweetTest extends FunctionalTest{

    @BeforeMethod
    public void setUpReTweetTest() {
        driver.get("https://twitter.com/login");
    }

    @Test
    public void testReTweetTest() {
        String tweetText = "Some message5";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName("7803691@gmail.com");
        loginPage.typePassword("1q2w3e");

        TweetPage tweetPage = loginPage.submitLogin();

        ReTweetPage reTweetPage = tweetPage.reTweet();

        reTweetPage.addComment("Some comment");
    }
}
