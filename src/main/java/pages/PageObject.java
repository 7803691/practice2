package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class PageObject{

    protected  WebDriver driver;



    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Log.debug("driver = " + driver.toString());
        Log.debug("Create object " + this);
    }





}
