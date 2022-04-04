package delkabo.config;

import org.aeonbits.owner.Config;

@Config.Sources({
       "classpath:${env}.properties"
})
public interface ProjectConfig extends Config {

    @Key("remoteUrl")
    String remoteUrl();

    @Key("browser")
    String getBrowser();

    @Key("versionBrowser")
    String versionBrowser();
}
