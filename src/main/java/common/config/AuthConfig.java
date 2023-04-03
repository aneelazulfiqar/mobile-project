package common.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({"classpath:authenticationConfig.properties"})
public interface AuthConfig extends Config {
    @Key("email")
    String getUserEmail();

    @Key("password")
    String getUserPassword();
}
