package test.day11_page_object_model;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {

    @Ignore
    @Test
    public void negative_login_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username = ConfigurationReader.getProperty("storemanager_username");

        usernameInput.sendKeys(username);

        passwordInput.sendKeys("lkjzdhvalk");

        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is NOT displayed");


    }

    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        String username=ConfigurationReader.getProperty("storemanager_username");

        LoginPage loginPage =new LoginPage();

        loginPage.usernameInput.sendKeys(username);

        loginPage.passwordInput.sendKeys("jkjlksdf");

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText =loginPage.errorMessage.getText();
        String expectedText="Invalid user name or password.";

    }

    @Test
    public void tc31_wrong_username_test(){


    }


}
