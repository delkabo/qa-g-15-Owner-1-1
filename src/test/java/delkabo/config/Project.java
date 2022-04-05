package delkabo.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static ProjectConfig webConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean configRemote() {
        return !webConfig.remoteUrl().equals("");
    }

    public static String webBrowser() {
        return webConfig.getBrowser();
    }

    public static String browserSize() { return webConfig.browserSize(); }

    public static String webVersionBrowser() {
        return webConfig.versionBrowser();
    }

}
