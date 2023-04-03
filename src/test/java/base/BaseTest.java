package base;

import common.config.AuthConfig;
import common.config.ConfigProvider;
import common.driver.AndroidDriverProvider;
import common.driver.DriverType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NotFoundException;

import java.net.MalformedURLException;

public class BaseTest {

    private final AuthConfig CONFIGURATION = ConfigProvider.getAuthConfig();

    protected String getUserEmail() {
        return CONFIGURATION.getUserEmail();
    }

    protected String getUserPassword() {
        return CONFIGURATION.getUserPassword();
    }

    public AppiumDriver<MobileElement> driver;

    public void initDriver(DriverType type)
            throws MalformedURLException, NotFoundException {
        switch (type) {
            case ANDROID:
                AndroidDriverProvider provider = new AndroidDriverProvider();
                driver = provider.get();
                break;

            case IOS:
            default:
                throw new NotFoundException("Driver type not found");
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
