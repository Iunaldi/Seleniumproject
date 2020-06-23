package test.day6_testing_dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC04 {

    //TC #4: Selecting value from multiple select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select all the options from multiple select dropdown.
    // 4.Print out all selected values.
    // 5.Deselect all values.

    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void TearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();

    }
    @Test
    public void multiple(){
        Select select=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions =select.getOptions();

        for (WebElement each:allOptions){
            each.click();
            System.out.println(each.getText());
            Assert.assertTrue(each.isSelected());
        }

        select.deselectAll();
         for (WebElement each:allOptions){
             Assert.assertFalse(each.isSelected());
         }

    }

}
