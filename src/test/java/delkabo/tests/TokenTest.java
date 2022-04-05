package delkabo.tests;

import delkabo.config.TokenConfig;
import jdk.jfr.Description;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TokenTest {

    Path path = Paths.get("C:/Users/delkabo/Desktop/token.properties");
    String pathString = path.toString();

    @BeforeEach
    public void deleteStart() throws Exception {
        Files.deleteIfExists(path);
    }

    @Test
    @DisplayName("проверка token.properties на рабочем столе")
    @Description("проверка token.properties на рабочем столе")
    void tokenTest() throws  Exception{

        File newFile = new File(pathString);
        String content = "token=ololoshkaFile";
        Files.write(path, content.getBytes()); // сохдаем файл и записываем контент

        TokenConfig config = ConfigFactory.create(TokenConfig
                .class, System.getProperties());
        String token = config.token(); // вытаскиваем параметр токена из созданного файла token.properties


        assertThat(newFile.getName()).isEqualTo("token.properties");
        assertThat(token).isEqualTo("ololoshkaFile"); // проверяем чтобы параметр в файле работал и соответствовал тому что записано

        BufferedReader reader = new BufferedReader(new FileReader(pathString));
        String whatIsInFile = reader.readLine(); //считываем все что записано в файл
        reader.close();
        System.out.println(whatIsInFile); //выводим то что считали
    }

    @Test
    @DisplayName("проверка token.properties в classpath")
    @Description("если нет локального token.properties, то считать из classpath")
    void tokenTestIfNoLocal() {

        TokenConfig config = ConfigFactory.create(TokenConfig.class, System.getProperties());
        assertThat(config.token()).isEqualTo("ololoshka"); //токен ololoshka записан classpath:token.properties

    }
}
