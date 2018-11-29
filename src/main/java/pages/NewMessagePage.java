package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMessagePage extends PageObject {


    private By startNewMessageButton = By.className("dm-new-button");
    private By sendTo = By.xpath("/html/body/div[8]/div/div[3]/div[1]/div/div[2]/div[2]/div/ul[1]/li/textarea");
    private By nextButton = By.className("dm-initiate-conversation");
    private By areaForMessage = By.id("tweet-box-dm-conversation");
    private By sendButton = By.className("messaging-text");
    private By closeMessageButton = By.xpath("/html/body/div[8]/div/div[3]/div[2]/div/div[1]/div[1]/div[2]/button[2]/span[1]");
    private By accIsSelected = By.className("DMTokenizedMultiselectSuggestion");
    private WebDriverWait wait = new WebDriverWait(driver, 20);

    public NewMessagePage openMessageWindow(){
        driver.findElement(startNewMessageButton).click();
        return this;
    }

    public NewMessagePage sendMessage(String recipient, String message){
        driver.findElement(sendTo).sendKeys(recipient);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(accIsSelected)));
        driver.findElement(nextButton).click();
        driver.findElement(areaForMessage).sendKeys(message);
        driver.findElement(sendButton).click();
        return this;
    }



    public TweetPage closeMessageWindow(){
        driver.findElement(closeMessageButton).click();
        return new TweetPage();
    }

}
