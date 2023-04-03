package pages;

import common.page.BasePage;
import common.page.PageContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String MAIN_SCREEN_ID = "android:id/content";
    private final String EMAIL_INPUT = "nl.moboa.myclay:id/input";
    private final String CONTINUE_BUTTON = "nl.moboa.myclay:id/login_button";
    private final String PASSWORD_INPUT = "//input[@name=\"password\"]";
    private final String LOGIN_BUTTON = "//button[@name=\"SubmitButton\"]";

    @AndroidFindBy(id = MAIN_SCREEN_ID)
    MobileElement main_screen;
    @AndroidFindBy(id = EMAIL_INPUT)
    MobileElement enter_email;
    @AndroidFindBy(id = CONTINUE_BUTTON)
    MobileElement continue_btn;
    @FindBy(xpath = PASSWORD_INPUT)
    WebElement enter_password;
    @FindBy(xpath = LOGIN_BUTTON)
    WebElement login_button;

    @Step
    public void mainPageVisibility() {
        waitForVisibility(main_screen);
    }

    @Step("Entering email: {0}")
    public void enterEmailText(String username) {
        enterText(enter_email, username);
    }

    @Step
    public void clickContinueButton() {
        click(continue_btn);
    }

    @Step
    public void changePageContext(PageContext context) {
        changeDriverContext(context);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        enterText(enter_password, password);
    }

    @Step
    public void pressLoginButton() {
        click(login_button);
    }

    @Step("User logs in with username:{0} and password:{1}")
    public void loginInApp(String username, String password) {
        mainPageVisibility();
        enterEmailText(username);
        clickContinueButton();
        changePageContext(PageContext.WEB_VIEW);
        enterPassword(password);
        pressLoginButton();
    }

}
