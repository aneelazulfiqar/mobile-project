package pages;

import common.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class DeviceActivationPage extends BasePage {
    public DeviceActivationPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String ACTIVATION_SUCCESS_SCREEN = "nl.moboa.myclay:id/mk_activation_root_layout";
    private final String ACTIVATION_CONTINUE_BUTTON = "nl.moboa.myclay:id/positive_button";
    @AndroidFindBy(id = ACTIVATION_SUCCESS_SCREEN)
    MobileElement activation_screen;
    @AndroidFindBy(id = ACTIVATION_CONTINUE_BUTTON)
    MobileElement continue_button;

    @Step
    public void activationScreenIsDisplayed() {
        isDisplayed(activation_screen);
    }

    @Step
    public void clickActivationContinueButton() {
        click(continue_button);
    }

    @Step("User activates device")
    public void continueWithDeviceActivation() {
        activationScreenIsDisplayed();
        clickActivationContinueButton();
    }
}
