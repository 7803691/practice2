package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Log;

public class ReTweetPage extends PageObject {

    @FindBy(id="retweet-with-comment")
    private WebElement reTweetBox;
    @FindBy(css = "span.RetweetDialog-tweetActionLabel")
    private WebElement reTweetButton;

    public ReTweetPage(WebDriver driver) {
        super(driver);
    }


    public TweetPage addComment(String comment){
        Log.info("Write comment with text - " + comment);
        this.reTweetBox.sendKeys(comment);
        Log.info("Click on \"Retweet buttom\"");
        this.reTweetButton.click();
        Log.debug("Return main tweet page");
        return new TweetPage(driver);
    }
}
