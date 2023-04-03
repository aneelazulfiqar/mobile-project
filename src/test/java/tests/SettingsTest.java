package tests;

import base.BaseTest;
import common.driver.DriverType;
import common.report.Listener;
import pages.data.SettingsPageData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;

@Listeners({Listener.class})
public class SettingsTest extends BaseTest {

    private SettingsPage settingsPage;

    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        initDriver(DriverType.ANDROID);
        openHomeScreen();
        settingsPage = new SettingsPage(driver);
    }

    @Story("Verify settings page")
    @Test(description = "Verify user email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user email on settings page")
    public void verifyUserEmailOnSettingsPage() {
        String userEmail = settingsPage.getUserEmail();
        Assert.assertEquals(userEmail, getUserEmail());
    }

    @Story("Verify settings page")
    @Test(description = "Verify user's full name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user full name on settings page")
    public void verifyUserFullNameOnSettingsPage() {
        String userFullName = settingsPage.getUserFullName();
        Assert.assertEquals(userFullName, SettingsPageData.USER_FULL_NAME);
    }

    @Story("Verify settings page")
    @Test(description = "Verify image is displayed")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify image on settings page")
    public void verifyUserImageIsDisplayedOnSettingsPage() {
        Boolean imageDisplay = settingsPage.imageIsDisplayed();
        Assert.assertTrue(imageDisplay);
    }

    @AfterTest
    public void tearDown() {
        ManageAccountsPage manageAccountPage = new ManageAccountsPage(driver);

        settingsPage.scrollAndClickLogoutButton(SettingsPageData.LOG_OUT_TEXT);
        manageAccountPage.deleteUserData();
        super.tearDown();
    }

    private void openHomeScreen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SitePage sitePage = new SitePage(driver);
        WalkthroughPage walkthroughPage = new WalkthroughPage(driver);
        HomePage homeScreenPage = new HomePage(driver);

        loginPage.loginInApp(getUserEmail(), getUserPassword());
        sitePage.selectSite();
        walkthroughPage.skipWalkThroughScreen();
        DeviceActivationPage activationPage = new DeviceActivationPage(driver);
        Thread.sleep(2000);
        activationPage.continueWithDeviceActivation();
        walkthroughPage.skipWalkThroughScreen();

        homeScreenPage.gotoSettingsPage();
    }
}
