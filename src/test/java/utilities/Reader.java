package utilities;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    static Properties properties = new Properties();


    static FileInputStream path;

    static {
        try {
            path = new FileInputStream("configuration.properties");
            properties.load(path);
            path.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Properties file not fount.");
        }
            }

            public static String cagir(String keyWord){
            return properties.getProperty(keyWord);
            }

}
