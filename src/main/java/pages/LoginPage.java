package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HighlightElement;
import utils.Log;

public class LoginPage extends PageObject {


    @FindBy(className = "js-username-field")
    private WebElement usernameLocator;
    @FindBy(className="js-password-field")
    private WebElement passwordLocator;
    @FindBy(className="EdgeButtom--medium")
    private WebElement loginButtonLocator;
    private WebDriverWait wait = new WebDriverWait(driver, 10);

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage typeUserName(String userName){
        wait.until(ExpectedConditions.visibilityOf(this.usernameLocator));
        Log.debug("HighlightElement " + this.usernameLocator);
        HighlightElement.HighlightElement(driver,this.usernameLocator);
        Log.info("Send to input user name - " + userName);
        this.usernameLocator.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password){
        wait.until(ExpectedConditions.visibilityOf(this.loginButtonLocator));
        Log.info("Send to input password - " + password);
        this.passwordLocator.sendKeys(password);
        return this;
    }

    public TweetPage submitLogin(){
        Log.info("Click on \"Log in\" button on login page");
        this.loginButtonLocator.click();
        return new TweetPage(driver);

    }


    public LoginPage submitLoginExpectingFailure(){
        this.loginButtonLocator.submit();
        return new LoginPage(driver);
    }

    public TweetPage loginAs(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        return submitLogin();
    }


}
