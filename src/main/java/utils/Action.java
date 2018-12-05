package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

    public static void inspectElement(WebDriver driver, WebElement element) throws InterruptedException {

        Actions builder = new Actions(driver);
        builder.moveToElement(element);
        Thread.sleep(5000);
        builder.contextClick(element).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        System.out.println("ee");
    }

}
