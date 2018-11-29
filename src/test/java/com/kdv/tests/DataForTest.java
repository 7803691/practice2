package com.kdv.tests;

import org.testng.annotations.DataProvider;

public class DataForTest {


    @DataProvider(name = "dataForLogin")
    public static Object [][] dataForLogin(){
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e"},
                {"7835177@gmail.com","1q2w3e"}
        };
    }


    @DataProvider(name = "dataForSimpleTweet")
    public static Object [][] dataForSimpleTweet(){
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e","Message simple twitt from testAccount121"},
                {"7835177@gmail.com","1q2w3e","Message from testAccount2"}
        };
    }




}
