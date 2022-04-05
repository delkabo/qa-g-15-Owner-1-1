package delkabo.tests;


import delkabo.config.DriverSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class WebDriverTest extends TestBase{

    @Test
    public void getConfigTest() {
        open("https://yandex.ru/internet/");
        String getBrowser = $$(".general-info__parameter")
                .findBy(text("Браузер")).getText();
        System.out.println(getBrowser);
    }

}
