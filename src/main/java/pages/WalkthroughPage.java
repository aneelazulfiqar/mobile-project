package pages;

import common.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class WalkthroughPage extends BasePage {
    public WalkthroughPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String WALKTHROUGH_SCREEN = "nl.moboa.myclay:id/walkthrough_pager";
    private final String SKIP_BUTTON = "nl.moboa.myclay:id/skip_button";

    @AndroidFindBy(id = WALKTHROUGH_SCREEN)
    public MobileElement screen;

    @AndroidFindBy(id = SKIP_BUTTON)
    public MobileElement skipButton;

    @Step
    public void walkthroughScreenIsVisible() {
        waitForVisibility(screen);
    }

    @Step
    public void clickSkipButton() {
        click(skipButton);
    }

    @Step("User skips walkthrough")
    public void skipWalkThroughScreen() {
        walkthroughScreenIsVisible();
        clickSkipButton();
    }
}
