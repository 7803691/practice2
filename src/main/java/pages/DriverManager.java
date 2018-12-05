package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;


public class DriverManager{

    private WebDriver driver;

    private static DriverManager instance;


    private DriverManager(){
    }

    public static DriverManager getInstance(){
        if (instance == null){
            instance =  new DriverManager();
           // instance.getDriver();
        }
        return instance;
    }

    public WebDriver getDriver(){
        if(PropertyManager.getInstance().getBrowser().equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
        }else if (PropertyManager.getInstance().getBrowser().equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        return driver;
    }


    public void setUpDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void quit(){
        driver.quit();
    }

    public void openURL(String url){
        driver.get(url);
    }


}
