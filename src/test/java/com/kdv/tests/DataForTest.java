package com.kdv.tests;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class DataForTest {


    public static String getRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    @DataProvider(name = "dataForLogin")
    public static Object [][] dataForLogin(){
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e"},
              //  {"7835177@gmail.com","1q2w3e"}
        };
    }


    @DataProvider(name = "dataForSimpleTweet")
    public static Object [][] dataForSimpleTweet(){
        String message = getRandomString();
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e",message},
                //{"7835177@gmail.com","1q2w3e","Message from testAccount2"}
        };
    }


    @DataProvider(name = "dataForTweetWithImage")
    public static Object [][] dataForTweetWithImage(){
        String message = getRandomString();
        return new Object[][]{
                {"7803691@gmail.com","1q2w3e",message, "C:\\Users\\admin\\Documents\\dumps\\123.jpg"},
                // {"7835177@gmail.com","1q2w3e","Message from testAccount2"}
        };
    }


}
