package test.Practice;


import utilities.ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class practice {

    public static void main(String[] args) {
        Properties data =new Properties();

        try{

            FileInputStream path=new FileInputStream("configuration.properties");

            data.load(path);

            path.close();




        } catch (IOException e) {

            e.printStackTrace();
        }

        String name1= data.getProperty("username1");


    }
}

