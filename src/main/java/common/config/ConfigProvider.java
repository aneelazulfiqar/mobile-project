package common.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigProvider {

    public static AndroidCapabilitiesConfig getAndroidCapabilities() {
        return ConfigCache.getOrCreate(AndroidCapabilitiesConfig.class);
    }

    public static AuthConfig getAuthConfig() {
        return ConfigCache.getOrCreate(AuthConfig.class);
    }
}
