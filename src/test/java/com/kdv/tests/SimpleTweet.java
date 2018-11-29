package com.kdv.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.LoginPage;
import pages.TweetPage;

public class SimpleTweet extends FunctionalTest {

    private FirstPage firstPage;

    @BeforeMethod
    public void setUpSimpleTweet() {
        driver.get("https://twitter.com");
    }

    @Test(dataProvider = "dataForSimpleTweet", dataProviderClass = DataForTest.class)
    public void testSimpleTweet(String login, String password, String message) {
        firstPage = new FirstPage(driver);
        LoginPage loginPage =firstPage.clickOnLogin();
        loginPage.typeUserName(login);
        loginPage.typePassword(password);
        TweetPage tweetPage = loginPage.submitLogin();

        tweetPage.writeSimpleTweet(message);
        System.out.println(tweetPage.getMessageFromLastTweet());
        Assert.assertEquals(message, tweetPage.getMessageFromLastTweet());
        firstPage = tweetPage.logout();
    }
}
