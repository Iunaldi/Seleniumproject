package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;


import java.util.concurrent.TimeUnit;

public class TC03 {

    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select “December 1st, 1921” and verify it is selected.
    //      Select year using:      visible text
    //      Select month using :    value attribute
    //      Select day using:       index number

    WebDriver driver;


    @BeforeTest
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.get("http://practice.cybertekschool.com/dropdown");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @Test
    public void selectYear(){
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1921");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertEquals(selectYear.getFirstSelectedOption().getText(),"1921");
    }

    @Test
    public void selectMoth(){
        Select select =new Select(driver.findElement(By.xpath("//select[@id='month']")));
        select.selectByValue("11");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"December");
    }

    @Test
    public void selectDay(){
        Select select=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        select.selectByIndex(0);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
