package com.kdv.tests;

import pages.LoginPage;
import pages.ReTweetPage;
import pages.TweetPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReTweetTest extends FunctionalTest {

    @BeforeMethod
    public void setUpReTweetTest() {
        driver.get("https://twitter.com/login");
    }

    @Test(dataProvider = "dataForSimpleTweet",dataProviderClass = DataForTest.class)
    public void testReTweetTest(String login, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(login);
        loginPage.typePassword(password);

        TweetPage tweetPage = loginPage.submitLogin();

        ReTweetPage reTweetPage = tweetPage.reTweet();

        reTweetPage.addComment(message);



    }
}
