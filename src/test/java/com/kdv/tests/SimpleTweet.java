package com.kdv.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.LoginPage;
import utils.PageLoadCondition;
import pages.TweetPage;

public class SimpleTweet extends FunctionalTest {

    private FirstPage firstPage;
    private LoginPage loginPage;
    private TweetPage tweetPage;

    @BeforeMethod
    public void setUpSimpleTweet() {
        driver.get("https://twitter.com");
    }

    @Test(dataProvider = "dataForSimpleTweet", dataProviderClass = DataForTest.class)
    public void testSimpleTweet(String login, String password, String message) {
        firstPage = new FirstPage(driver);
        loginPage =firstPage.clickOnLogin();
        loginPage.typeUserName(login);
        loginPage.typePassword(password);
        tweetPage = loginPage.submitLogin();

        //Call function for waiting page complete loaded
        PageLoadCondition.waitForLoad(driver);


        System.out.println(tweetPage.getCountOfTwitts());
        tweetPage.writeSimpleTweet(message);
        System.out.println(tweetPage.getMessageFromLastTweet());
        System.out.println(tweetPage.getCountOfTwitts());

        Assert.assertEquals(message, tweetPage.getMessageFromLastTweet());
        firstPage = tweetPage.logout();
    }
}
