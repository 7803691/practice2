package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage extends PageObject {

    private By firstButtonLogin = By.className("StaticLoggedOutHomePage-buttonLogin");

    public LoginPage clickOnLogin(){
        driver.findElement(firstButtonLogin).click();
        return new LoginPage();
    }

}
