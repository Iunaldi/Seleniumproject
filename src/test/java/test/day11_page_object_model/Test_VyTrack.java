package test.day11_page_object_model;

import org.testng.annotations.Test;
import pages.vyTrack_login;
import utilities.ConfigurationReader;

public class Test_VyTrack {

    @Test
    public void LoginPageTest(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        vyTrack_login loginPage=new vyTrack_login();
        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.pessword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();


    }
}
