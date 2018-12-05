package com.kdv.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.LoginPage;
import pages.MessagePage;
import pages.TweetPage;
import utils.PageLoadCondition;


//@Listeners({ScreenShotOnFailure.class})
public class SendMessageTest extends FunctionalTest {

    FirstPage firstPage;
    TweetPage tweetPage;
    LoginPage loginPage;
    MessagePage newMessagePage;



    @BeforeMethod
    public void setUpSendMessageTest() {
        driver.get("https://twitter.com");
    }




    @Parameters({"login_1" ,"password_1","message"})
    @Test
    public void testSendMessage(@Optional("7803691@gmail.co") String login, @Optional("1q2w3e") String password,@Optional("Optional") String message) {

        firstPage = new FirstPage(driver);

        loginPage = firstPage.clickOnLogin();

        loginPage.typeUserName(login);

        loginPage.typePassword(password);

        tweetPage = loginPage.submitLogin();

        newMessagePage = tweetPage.newMessage();

        newMessagePage.openMessageWindow();

        PageLoadCondition.waitForLoad(driver);

        newMessagePage.sendMessage("@testAcc02011488",message);

        System.out.println("last message Text= "+ newMessagePage.getTextLastMessage());

        Assert.assertEquals(message,newMessagePage.getTextLastMessage());

        tweetPage = newMessagePage.closeMessageWindow();

        PageLoadCondition.waitForLoad(driver);

        firstPage = tweetPage.logout();
    }
}
