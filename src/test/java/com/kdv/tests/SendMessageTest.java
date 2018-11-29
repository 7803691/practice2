package com.kdv.tests;

import pages.LoginPage;
import pages.NewMessagePage;
import pages.TweetPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendMessageTest extends FunctionalTest {

    @BeforeMethod
    public void setUpSendMessageTest() {
        driver.get("https://twitter.com/login");
    }

    @Test
    public void testSendMessage() {
        String tweetText = "Some message5";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName("7803691@gmail.com");
        loginPage.typePassword("1q2w3e");

        TweetPage tweetPage = loginPage.submitLogin();
        NewMessagePage newMessagePage = tweetPage.newMessage();
        newMessagePage.openMessageWindow();
        newMessagePage.sendMessage("@testAcc02011488","Some message2");
        newMessagePage.closeMessageWindow();

    }
}
