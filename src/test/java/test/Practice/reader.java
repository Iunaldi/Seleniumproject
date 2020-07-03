package test.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class reader {

    public static void main(String[] args)  {

        String key="browser2";

        Properties value= new Properties();
        try {
            FileInputStream file =new FileInputStream("configuration.properties");
            value.load(file);
        } catch (IOException e) {
            System.out.println(" Properties file not found.");
            e.printStackTrace();
        }

        System.out.println(key+" : "+value.getProperty(key));

    }

}
