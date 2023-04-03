package pages;

import common.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class ManageAccountsPage extends BasePage {

    public ManageAccountsPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String MANAGE_ACCOUNT_BUTTON = "nl.moboa.myclay:id/button_manage_accounts";
    private final String MANAGE_BUTTON = "nl.moboa.myclay:id/manage_button";
    private final String DELETE_BUTTON = "nl.moboa.myclay:id/delete_button";

    private final String CONFIRM_BUTTON = "nl.moboa.myclay:id/confirm_button";

    @AndroidFindBy(id = MANAGE_ACCOUNT_BUTTON)
    MobileElement manage_account_button;

    @AndroidFindBy(id = MANAGE_BUTTON)
    MobileElement manage_button;

    @AndroidFindBy(id = DELETE_BUTTON)
    MobileElement delete_button;

    @AndroidFindBy(id = CONFIRM_BUTTON)
    MobileElement confirm_button;

    @Step
    public void clickManageAccountButton() {
        click(manage_account_button);
    }

    @Step
    public void clickManageButton() {
        click(manage_button);
    }

    @Step
    public void clickDeleteButton() {
        click(delete_button);
    }

    @Step
    public void clickConfirmPopup() {
        click(confirm_button);
    }

    @Step("Remove User's data")
    public void deleteUserData() {
        clickManageAccountButton();
        clickManageButton();
        clickDeleteButton();
        clickConfirmPopup();
    }


}