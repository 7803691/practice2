package com.kdv.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.LoginPage;
import pages.MessagePage;
import pages.TweetPage;

//@Listeners(ScreenShotOnFailure.class)
public class MessageDeliveredTest extends FunctionalTest {

    FirstPage firstPage;
    TweetPage tweetPage;
    LoginPage loginPage;
    MessagePage messagePage;

    @BeforeMethod
    public void setUpSendMessageTest() {
        driver.get("https://twitter.com");
    }

    @Parameters({"login_2", "password_2", "message"})
    @Test
    public void testMessageDelivered(String login, String password, String message){

        firstPage = new FirstPage(driver);

        loginPage = firstPage.clickOnLogin();

        tweetPage = loginPage.loginAs(login, password);

        messagePage = tweetPage.newMessage();

        messagePage.selectSender();

        Assert.assertEquals(message,messagePage.getTextLastMessage());

        tweetPage = messagePage.closeMessageWindow();

        firstPage = tweetPage.logout();
    }


}
