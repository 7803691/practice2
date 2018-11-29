package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver = DriverManager.getInstance().getDriver();

    public PageObject() {
        PageFactory.initElements(driver, this);
    }
}
