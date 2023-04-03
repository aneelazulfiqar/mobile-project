package pages;

import common.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String NAVIGATION_BAR = "nl.moboa.myclay:id/bottom_navigation_bar";
    private final String SETTINGS_BUTTON = "nl.moboa.myclay:id/tab_setting";

    @AndroidFindBy(id = NAVIGATION_BAR)
    public MobileElement nav_bar;

    @AndroidFindBy(id = SETTINGS_BUTTON)
    public MobileElement settings_button;

    @Step
    public void homeNavigationBarIsVisible() {
        waitForVisibility(nav_bar);
    }

    @Step
    public void clickSettingsButton() {
        click(settings_button);
    }

    @Step("User clicks on settings button at nav bar")
    public void gotoSettingsPage() {
        homeNavigationBarIsVisible();
        clickSettingsButton();
    }
}
