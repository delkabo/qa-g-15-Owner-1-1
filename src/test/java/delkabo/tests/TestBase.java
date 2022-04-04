package delkabo.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import delkabo.config.DriverSettings;
import delkabo.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {


//    @BeforeAll
//    static void setUp() {
//        DriverSettings.configure();
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
//        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
