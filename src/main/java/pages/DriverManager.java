package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager instance;

    public static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public void setupDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
