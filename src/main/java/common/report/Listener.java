package common.report;

import common.driver.AndroidDriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.MalformedURLException;

public class Listener implements ITestListener {
    AndroidDriverProvider androidDriverProvider = new AndroidDriverProvider();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("onTestStart method executing " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("onTestSuccess method executing" + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("onTestFailure method executing" + getTestMethodName(iTestResult) + " failed");
        AppiumDriver<MobileElement> driver;
        try {
            driver = androidDriverProvider.get();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            try {
                saveScreenshotPNG(driver);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("onTestSkipped method executing" + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("onStart method " + iTestContext.getName());
        try {
            iTestContext.setAttribute("AndroidDriver", androidDriverProvider.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("onFinish method executing " + iTestContext.getName());
        try {
            iTestContext.setAttribute("AndroidDriver", androidDriverProvider.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] saveScreenshotPNG(AppiumDriver<MobileElement> driver) throws IOException {
        return driver.getScreenshotAs(OutputType.BYTES);
    }


}
