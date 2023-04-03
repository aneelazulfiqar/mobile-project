package common.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    private final AppiumDriver<MobileElement> driver;
    public static final long WAIT = 20;

    public BasePage(AppiumDriver<MobileElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void scrollAndClick(String visibleText) {
        AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) driver;
        MobileElement elementByAndroidUIAutomator = androidDriver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" +
                        ".scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector()" +
                        ".textContains(\"" + visibleText + "\").instance(0))");
        click(elementByAndroidUIAutomator);
    }


    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        clear(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public Boolean isDisplayed(WebElement element) {
        waitForVisibility(element);
        return element.isDisplayed();
    }

    public void changeDriverContext(PageContext pageContext) {
        Set<String> contextNames = driver.getContextHandles();
        String context = pageContext.name;
        for (String contextName : contextNames) {
            if (contextName.contains(context))
                driver.context(contextName);
        }
    }
}
