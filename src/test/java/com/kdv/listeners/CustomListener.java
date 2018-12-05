//package utils;
//
//import com.kdv.tests.FunctionalTest;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import pages.DriverManager;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class ScreenShotOnFailure implements ITestListener {
//
//    private String pathToScreenshot = "d:\\Project\\practice2\\screenshots\\";
//    private WebDriver driver;
//    private File srcFile;
//
//
//    @Override
//    public void onTestStart(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        Object testClass = result.getTestClass().getRealClass();
//        Log.debug("Try to get driver");
//        driver = ((FunctionalTest)testClass.g;
//        Log.debug("Driver is " + driver);
//        srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(srcFile, new File(pathToScreenshot+System.currentTimeMillis()+".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//
//    }
//}
