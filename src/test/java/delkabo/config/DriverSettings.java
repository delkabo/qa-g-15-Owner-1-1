package delkabo.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

import static delkabo.config.Project.*;

public class DriverSettings {

    public static void configure() {
//        System.setProperty("env", "locale");

        Properties p = System.getProperties();
        String s = p.getProperty("env");
//        System.out.println(s); проверка наличия значения удаленного запуска тестов remote, locale или null
        if (s == null){
            System.setProperty("env", "locale");
        }

        Configuration.browser = webBrowser();
        Configuration.browserVersion = webVersionBrowser();

        DesiredCapabilities capabilities = new DesiredCapabilities();


        if(configRemote()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = webConfig.remoteUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }


}
