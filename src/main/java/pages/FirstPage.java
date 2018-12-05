package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Log;

public class FirstPage extends PageObject {

    @FindBy(className="StaticLoggedOutHomePage-buttonLogin")
    private WebElement firstButtonLogin;

    public WebElement getFirstButtonLogin() {
        return firstButtonLogin;
    }

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogin(){
        Log.info("Click on \"Log in\" button on First page");
        this.firstButtonLogin.click();
        return new LoginPage(driver);
    }

}
