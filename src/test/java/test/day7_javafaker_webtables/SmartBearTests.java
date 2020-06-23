package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: "Tester"
    //4. Enter password: "test"
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void p1_smartbear_login_test(){
        WebElement imputUsername =driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        imputUsername.sendKeys("Tester");

        WebElement imputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        imputPassword.sendKeys("test");

        WebElement loginButton=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
        loginButton.click();
        System.out.println("loginButton = " + loginButton);
        

        List<WebElement> allLinks =driver.findElements(By.xpath("//body//a"));



        int expectedNumberOfLinks=allLinks.size();
        Assert.assertEquals(expectedNumberOfLinks,6);

        for (WebElement each:allLinks){
            System.out.println(each.getText());
        }
    }
}
