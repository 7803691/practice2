package com.kdv.tests;

import pages.LoginPage;
import pages.TweetPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TweetWithImage extends FunctionalTest {

    @BeforeMethod
    public void setUpTweetWithImage() {
        driver.get("https://twitter.com/login");
    }

    @Test
    public void testTweetWithImage() {
        By tweetListLocator;
        String tweetText = "Some message5";
        String pathToFile = "C:\\Users\\admin\\Documents\\dumps\\123.jpg";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName("7803691@gmail.com");
        loginPage.typePassword("1q2w3e");
        TweetPage tweetPage = loginPage.submitLogin();
        tweetPage.writeTweetWithImage(tweetText,"C:\\Users\\admin\\Documents\\dumps\\123.jpg");
    }


}
