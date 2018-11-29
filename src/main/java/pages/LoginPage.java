package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {


    private By usernameLocator = By.className("js-username-field");
    private By passwordLocator = By.className("js-password-field");
    private By loginButtonLocator = By.className("EdgeButtom--medium");
    private WebDriverWait wait = new WebDriverWait(driver, 10);


    public LoginPage typeUserName(String userName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(usernameLocator)));
        driver.findElement(usernameLocator).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButtonLocator)));
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public TweetPage submitLogin(){
        driver.findElement(loginButtonLocator).submit();
        return new TweetPage();

    }


    public LoginPage submitLoginExpectingFailure(){
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage();
    }

    public TweetPage loginAs(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        return submitLogin();
    }


}
