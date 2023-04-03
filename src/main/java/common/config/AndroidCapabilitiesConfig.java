package common.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({"classpath:android-capabilities.properties"})
public interface AndroidCapabilitiesConfig extends Config {
    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformName")
    String getPlatformName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("autoGrantPermissions")
    String getAutoGrantPermissions();

    @Key("automationName")
    String getAutomationName();

    @Key("appiumServerUrl")
    String getAppiumServerUrl();

    @Key("no_reset")
    String getNoRest();

    @Key("apkPath")
    String getApkPath();

    @Key("full-reset")
    String getFullRest();
}