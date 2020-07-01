package test.day8_alerts_iframes_windows;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.concurrent.TimeUnit;

public class TC_SmartBearPractice {

    //TC #9: SmartBear delete order
    // 1.Open browser and login to SmartBear
    // 2.Delete “Mark Smith” from the list
    // 3.Assert it is deleted from the list

    WebDriver driver;


    @BeforeTest
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @BeforeMethod
    public void login() {
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test(priority = 2)
    public void deleteItem() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement deleteItem = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));

        deleteItem.click();


        WebElement deleteButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));

        deleteButton.click();

        SmartBearUtilities.verifyOrder(driver, "Mark Smith");


    }

    @Test(priority = 3)
    public void Edit() {

        //TC #10: SmartBear edit order
        // 1.Open browser and login to SmartBear
        // 2.Click to edit button from the right for “Steve Johns”
        // 3.Change name to “Michael Jordan”
        // 4.Click Update
        // 5.Assert “Michael Jordan” is in the list

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement deleteItem = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        deleteItem.click();

        WebElement editButton = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[13]"));
        editButton.click();
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.clear();
        customerName.sendKeys("Michael Jordan");
        WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//td[.='Michael Jordan']")).isDisplayed());

    }

    @Test(priority = 4)
    public void delete() {
        SmartBearUtilities.deleteName(driver,"Clare Jefferson");
    }
}