package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReTweetPage extends PageObject {

    private By reTweetBox = By.id("retweet-with-comment");
    private By reTweetButton = By.cssSelector("span.RetweetDialog-tweetActionLabel");

    public TweetPage addComment(String comment){
        driver.findElement(reTweetBox).sendKeys(comment);
        driver.findElement(reTweetButton).click();
        return new TweetPage();
    }


}
