package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC05 {

    //C #5: Selecting value from non-select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Click to non-select dropdown
    // 4.Select Facebook from dropdown
    // 5.Verify title is “Facebook -Log In or Sign Up”


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void nonSelect(){
        WebElement menuButton =driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        menuButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement faceBookOption=driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[.='Facebook']"));
        faceBookOption.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        String title=driver.getTitle();
        Assert.assertEquals(title,"Facebook - Log In or Sign Up");



    }


}
