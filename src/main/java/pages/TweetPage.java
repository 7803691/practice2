package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TweetPage extends PageObject {

    private By accLocator = By.xpath("//*[a='testAccount1']");
    private By tweetBoxSmall = By.xpath("//*[div='What’s happening?']");
    private By tweetBoxBig = By.id("tweet-box-home-timeline");
    private By tweetButton = By.xpath("//*[@id='timeline']/div[2]/div/form/div[3]/div[2]/button");
    private By addImageButton = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[3]/div[1]/span[1]/div/div/label/input");
    private By lastTweetText = By.xpath("(//li[@data-item-type='tweet'])[1]/div/div/div[2]/p");
    private By tweetListLocator = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li");
    private By reTweetButton = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[4]/div[2]/ol[1]/li[1]/div[1]/div[2]/div[4]/div[2]/div[2]/button[1]/div/span[1]");
    private By messageButton = By.className("global-dm-nav");
    private By userMenuButton = By.id("user-dropdown-toggle");
    private By logoutButton = By.xpath("*//button[text()='Log out']");
    private By firstButtonLogin = By.className("StaticLoggedOutHomePage-buttonLogin");
    private WebDriverWait wait = new WebDriverWait(driver, 10);


    public String openPage(){
        String element = driver.findElement(accLocator).getText();
        return element;
    }

    public TweetPage writeSimpleTweet(String message){
        driver.findElement(tweetBoxSmall).click();
        driver.findElement(tweetBoxBig).sendKeys(message);
        driver.findElement(tweetButton).click();
        driver.navigate().refresh();
        driver.switchTo().alert().accept();
        return this;
    }


    public TweetPage writeTweetWithImage(String message, String pathToFile){

        driver.findElement(tweetBoxSmall).click();
        driver.findElement(tweetBoxBig).sendKeys(message);
        driver.findElement(addImageButton).sendKeys(pathToFile);
        driver.findElement(tweetButton).click();
        List<WebElement> counterTweetAfterAdd = driver.findElements(tweetListLocator);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tweetListLocator,counterTweetAfterAdd.size()));
        return this;
    }



    public ReTweetPage reTweet(){
        driver.findElement(reTweetButton).click();
        return new ReTweetPage();
    }


    public NewMessagePage newMessage (){
        driver.findElement(messageButton).click();
        return new NewMessagePage();
    }



    public String getMessageFromLastTweet(){
        String lastMessage = driver.findElement(lastTweetText).getText();
        return lastMessage;
    }


    public FirstPage logout(){
        driver.findElement(userMenuButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutButton)));
        driver.findElement(logoutButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstButtonLogin)));
        return new FirstPage();
    }

}
