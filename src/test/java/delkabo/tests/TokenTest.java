package delkabo.tests;

import delkabo.config.TokenConfig;
import org.aeonbits.owner.ConfigFactory;
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

    @Test
    void tokenTest() throws  Exception{
        TokenConfig config = ConfigFactory.create(TokenConfig.class, System.getProperties());
        String token = config.token();

        File newFile = new File(pathString);

        String content = "ololoshkaFile";
        Files.write(path, content.getBytes());

        assertThat(newFile.getName()).isEqualTo("token.properties");
        assertThat(config.token()).isEqualTo(content);

        BufferedReader reader = new BufferedReader(new FileReader(pathString));
        String whatIsInFile = reader.readLine();
        reader.close();
        System.out.println(whatIsInFile);

    }
}
