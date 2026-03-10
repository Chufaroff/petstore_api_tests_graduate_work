package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/api.properties"
})

public interface ApiConfig extends Config {

    @Key("baseApiUrl")
    @DefaultValue("https://petstore.swagger.io")
    String getBaseApiUrl();
}
