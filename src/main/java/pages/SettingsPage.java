package pages;

import common.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String EMAIL_FIELD = "nl.moboa.myclay:id/user_email";
    private final String FULL_NAME_FIELD = "nl.moboa.myclay:id/user_fullname";
    private final String USER_IMAGE = "nl.moboa.myclay:id/user_image";

    @AndroidFindBy(id = EMAIL_FIELD)
    MobileElement user_email;

    @AndroidFindBy(id = FULL_NAME_FIELD)
    MobileElement user_full_name;

    @AndroidFindBy(id = USER_IMAGE)
    MobileElement user_image_display;

    @Step
    public String getUserEmail() {
        return getText(user_email);
    }

    @Step
    public String getUserFullName() {
        return getText(user_full_name);
    }

    @Step
    public Boolean imageIsDisplayed() {
        return isDisplayed(user_image_display);
    }

    @Step("User scrolls and clicks log-out button")
    public void scrollAndClickLogoutButton(String visibleText) {
        super.scrollAndClick(visibleText);
    }
}
