package demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browser.properties"})
public interface BrowserConfig extends Config {
    @Key("dimension.width")
    int dimensionWidth();

    @Key("dimension.height")
    int dimensionHeight();
}


