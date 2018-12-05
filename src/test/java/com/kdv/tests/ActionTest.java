package com.kdv.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;
import utils.Action;

public class ActionTest extends FunctionalTest{

    private FirstPage firstPage;

    @BeforeMethod
    public void setUpLogin() {
        driver.get("https://twitter.com");
    }

    @Test
    public void testAction() throws InterruptedException {

        firstPage = new FirstPage(driver);

        Action.inspectElement(driver, firstPage.getFirstButtonLogin());

    }


}
