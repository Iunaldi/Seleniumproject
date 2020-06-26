package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.SmartBearUtilities;
import test.utilities.WebDriverFactory;


import java.util.concurrent.TimeUnit;

public class P09 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }



    @Test
    public void login(){
        WebElement SusanMacLaran= driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        String expectedDate = "01/05/2010";
        String actualDate=SusanMacLaran.getText();
        Assert.assertEquals(expectedDate,actualDate);

    }
}
