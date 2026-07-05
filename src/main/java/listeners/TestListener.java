package listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import driver.DriverFactory;
import reports.ExtentLogger;
import reports.ExtentManager;
import utilities.LoggerUtility;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
    	LoggerUtility.logger.info("Execution Started");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentLogger.setTest(extent.createTest(result.getName()));

        LoggerUtility.logger.info("Test Started : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentLogger.pass("Test Passed");

        LoggerUtility.logger.info("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        LoggerUtility.logger.info("Test Failed : " + result.getName());

        WebDriver driver = DriverFactory.getDriver();

        String path = ScreenshotUtility.captureScreenshot(driver, result.getName());

        ExtentLogger.getTest().fail(result.getThrowable());

        try {
            ExtentLogger.getTest() .addScreenCaptureFromPath(new File(path).getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoggerUtility.logger.info("Screenshot saved at : " + path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentLogger.skip("Test Skipped");

        LoggerUtility.logger.info("Test Skipped : " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        ExtentLogger.removeTest();

        LoggerUtility.logger.info("Execution Finished");
    }
}