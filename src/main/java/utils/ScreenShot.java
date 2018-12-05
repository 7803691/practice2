package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static void takeScreenShot(WebDriver driver, String methodName){
        String pathToScreenshot = "d:\\Project\\practice2\\screenshots\\";
        Log.debug("take screenshot");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Log.debug("save screenshot to " + pathToScreenshot);
            FileUtils.copyFile(srcFile, new File(pathToScreenshot+methodName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
