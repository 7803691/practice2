package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HighlightElement;
import utils.Log;

public class MessagePage extends PageObject {

    @FindBy(className="dm-new-button")
    private WebElement startNewMessageButton;

    @FindBy(xpath = "(//textarea[@class='TokenizedMultiselect-input twttr-directmessage-input js-initial-focus dm-to-input'])[1]")
    private WebElement sendTo;

    @FindBy(className = "dm-initiate-conversation")
    private WebElement nextButton;

    @FindBy(id = "tweet-box-dm-conversation")
    private WebElement areaForMessage;

    @FindBy(className = "messaging-text")
    private WebElement sendButton;

    @FindBy(xpath = "//div[contains(@class,'DMActivity DMConversation js-ariaDocument')]/div[1]/div[2]/button[2]/span[1]")
    private WebElement closeMessageButton;

    @FindBy(className = "DMTokenizedMultiselectSuggestion")
    private WebElement accIsSelected;

    @FindBy(xpath = "//ul[@id='DMComposeTypeaheadSuggestions'][1]/li[2]")
    private WebElement sendMessageTo;
    
    @FindBy(xpath = "(//div[@class='DirectMessage-contentContainer'])[last()]")
    private WebElement lastMessage;

    @FindBy(className = "DMInboxItem")
    private WebElement messageFrom;


    private WebDriverWait wait = new WebDriverWait(driver, 20);

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    public MessagePage openMessageWindow() {
        Log.info("Click on \"New message\" button");
        this.startNewMessageButton.click();
        return this;
    }

    public MessagePage sendMessage(String recipient, String message){
        Log.info("Input in \"Enter name field\" recipient -" + recipient);
        this.sendTo.sendKeys(recipient);
        Log.debug("Wait for \"Next\" button will be enable");
        wait.until(ExpectedConditions.visibilityOf(this.nextButton));
        Log.info("Click on \"Next\" button");
        this.nextButton.click();
        Log.info("Write message with text - " + message);
        this.areaForMessage.sendKeys(message);
        Log.info("Click on \"Send\" Button");
        this.sendButton.click();
        return this;
    }



    public MessagePage selectSender(){
        Log.info("Click on \"Sender\"");
        this.messageFrom.click();
        return this;
    }



    public TweetPage closeMessageWindow(){
        Log.debug("HighLight \"Close\" button");
        HighlightElement.HighlightElement(driver, this.closeMessageButton);
        Log.info("Click on \"Close\" button");
        this.closeMessageButton.click();
        Log.debug("return to main tweet page");
        return new TweetPage(driver);
    }


    public  String getTextLastMessage() {
        Log.debug("Get text from last message");
        return this.lastMessage.getText();
    }

}
