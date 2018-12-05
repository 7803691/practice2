package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HighlightElement;
import utils.Log;

import java.util.List;

public class TweetPage extends PageObject {

    @FindBy(xpath = "//div[@id='tweet-box-home-timeline']")
    private WebElement tweetBoxSmall;
    @FindBy(id = "tweet-box-home-timeline")
    private WebElement tweetBoxBig;
    @FindBy(xpath="//button[contains(@class,'tweet-action EdgeButton EdgeButton--primary js-tweet-btn')]")
    private WebElement tweetButton;
    @FindBy(xpath="//*[@id='timeline']/div[2]/div/form/div[3]/div[1]/span[1]/div/div/label/input")
    private WebElement addImageButton;
    @FindBy(xpath="(//li[@data-item-type='tweet'])[1]//div[2]/p")
    private WebElement lastTweetText;
    @FindBy(xpath="//div[@id='timeline']/div[4]/div[2]/ol/li")
    private List<WebElement> twitts;
    @FindBy(xpath="(//div[@class='stream-item-footer']/div[2]/div[2]/button)[1]")
    private WebElement reTweetButton;
    @FindBy(className="global-dm-nav")
    private WebElement messageButton;
    @FindBy(id = "user-dropdown-toggle")
    private WebElement userMenuButton;
    @FindBy(xpath="//li[@id='signout-button']")
    private WebElement logoutButton;
    @FindBy(className="StaticLoggedOutHomePage-buttonLogin")
    private WebElement firstButtonLogin;
    @FindBy(className="new-tweets-bar")
    private WebElement newTweetBar;
    @FindBy(className="stream-end")
    private WebElement endOfPage;
    @FindBy(xpath="(//li[@data-item-type='tweet'])[1]//img[@data-aria-label-part]")
    private WebElement lastAddedImage;
    private WebDriverWait wait = new WebDriverWait(driver, 20);



    public TweetPage(WebDriver driver) {
        super(driver);
    }




    public TweetPage writeSimpleTweet(String message){
        Log.info("Click on area for create new tweet");
        this.tweetBoxSmall.click();
        Log.info("Write new tweet with text - " + message);
        this.tweetBoxBig.sendKeys(message);
        Log.info("Click on \"Tweet\" button");
        this.tweetButton.click();
        Log.debug("Waiting for message \"New tweet\"");
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
//        driver.navigate().refresh();
//        driver.switchTo().alert().accept();
        return this;
    }


    public TweetPage writeTweetWithImage(String message, String pathToFile){
        Log.info("Click on area for create new tweet");
        this.tweetBoxSmall.click();
        Log.info("Write new tweet with text - " + message);
        this.tweetBoxBig.sendKeys(message);
        Log.info("Click on button \"Add photos and video\" with path to file - "+pathToFile);
        this.addImageButton.sendKeys(pathToFile);
        Log.info("Click on \"Tweet\" button");
        this.tweetButton.click();
        Log.debug("Waiting for message \"New tweet\"");
        wait.until(ExpectedConditions.visibilityOf(this.newTweetBar));
        return this;
    }



    public ReTweetPage reTweet(){
        Log.info("Click on \"ReTweet\" button");
        this.reTweetButton.click();
        Log.debug("Open ReTweet modal page");
        return new ReTweetPage(driver);
    }


    public MessagePage newMessage (){
        Log.info("Click on \"Messages\" button");
        this.messageButton.click();
        Log.debug("Open Messages page");
        return new MessagePage(driver);
    }



    public String getMessageFromLastTweet(){
        Log.debug("Get text from last Tweet");
        String lastMessage = this.lastTweetText.getText();
        return lastMessage;
    }


    public Boolean imagePresntInTwitt(){
        Log.debug("Check that image is present in last tweet");
        WebElement image = this.lastAddedImage;
        if(image.isDisplayed()){
            System.out.println("Image is present"+image.getText());
            return true;
        }else {
            System.out.println("Image is`t present");
            return false;
        }
    }


    public FirstPage logout(){
        HighlightElement.HighlightElement(driver,this.userMenuButton);
        Log.info("Click on \"Profile and Settings Icon\"");
        this.userMenuButton.click();
        Log.debug("Wait for \"Log Out\" item will be visible");
        wait.until(ExpectedConditions.visibilityOf(this.logoutButton));
        Log.info("Click on \"Log out\" item");
        this.logoutButton.click();
        Log.debug("Wait for \"Log out\" button on First Page ");
        wait.until(ExpectedConditions.visibilityOf(this.firstButtonLogin));
        return new FirstPage(driver);
    }


    public Integer getCountOfTwitts(){
        Log.debug("Get count of tweets");
        Log.debug("Run JavaScript which scroll page down and back to the top");
        ((JavascriptExecutor)driver).executeScript("window.scroll(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOf(this.endOfPage));
        ((JavascriptExecutor)driver).executeScript("window.scroll(document.body.scrollHeight,0)");
      //  List<WebElement> twitts = this.tweetListLocator;
        Integer countOfTwitts = twitts.size();
        return countOfTwitts;
    }

}
