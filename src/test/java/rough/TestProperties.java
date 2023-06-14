package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {


        Properties config=new Properties();
        Properties or=new Properties();
        FileInputStream fisConfig=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
        FileInputStream fisOr=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/or.properties");

        config.load(fisConfig);
        or.load(fisOr);
        System.out.println(config.getProperty("browser"));
        System.out.println(or.getProperty("bankManagerLoginButton"));


    }
}
