package pages;

import common.page.BasePage;
import common.page.PageContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.data.SitesPageData;

public class SitePage extends BasePage {
    public SitePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    private final String SEARCH_BUTTON = "nl.moboa.myclay:id/open_search_button";
    private final String SEARCH_INPUT = "nl.moboa.myclay:id/search_edit_text";
    private final String SITE_LIST_ITEM = "//android.view.ViewGroup[@content-desc=\"site_0\"]";
    @AndroidFindBy(id = SEARCH_BUTTON)
    MobileElement search_Button;
    @AndroidFindBy(id = SEARCH_INPUT)
    MobileElement search_Input;
    @AndroidFindBy(xpath = SITE_LIST_ITEM)
    MobileElement search_Item;

    @Step
    public void changePageContext(PageContext context) {
        changeDriverContext(context);
    }

    @Step
    public void clickSearchButton() {
        click(search_Button);
    }

    @Step
    public void searchText() {
        enterText(search_Input, SitesPageData.SITE_NAME);
    }

    @Step
    public void selectSearchedItem() {
        click(search_Item);
    }

    @Step("User selects site")
    public void selectSite() {
        changePageContext(PageContext.NATIVE);
        clickSearchButton();
        searchText();
        selectSearchedItem();
    }
}
