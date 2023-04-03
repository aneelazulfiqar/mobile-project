package common.driver;

import common.config.AndroidCapabilitiesConfig;
import common.config.ConfigProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverProvider {

    public String appDirectory = System.getProperty("user.dir");
    private final AndroidCapabilitiesConfig CONFIGURATION = ConfigProvider.getAndroidCapabilities();

    private static AppiumDriver<MobileElement> driver;

    public AppiumDriver<MobileElement> get() throws MalformedURLException {
        if (driver != null) {
            return driver;
        }

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //Desired capabilities to send to appium server
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CONFIGURATION.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CONFIGURATION.getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CONFIGURATION.getAutomationName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CONFIGURATION.getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, CONFIGURATION.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, CONFIGURATION.getNoRest());
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, CONFIGURATION.getFullRest());
        desiredCapabilities.setCapability("appActivity", CONFIGURATION.getAppActivity());
        desiredCapabilities.setCapability("appPackage", CONFIGURATION.getAppPackage());
        desiredCapabilities.setCapability("autoGrantPermissions", CONFIGURATION.getAutoGrantPermissions());
        desiredCapabilities.setCapability("appium:app", appDirectory + CONFIGURATION.getApkPath());
        //Setup of appium server url
        URL appiumServer = new URL(CONFIGURATION.getAppiumServerUrl());
        //start server on given port using provided desired capabilities
        driver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
        return driver;
    }
}
