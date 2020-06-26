package test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SmartBearUtilities {

    // •Create a method named verifyOrderin SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.Practice


    public static void login(WebDriver driver) {
            WebElement imputUsername = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
            imputUsername.sendKeys("Tester");
            WebElement imputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
            imputPassword.sendKeys("test");
            WebElement loginButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
            loginButton.click();
        }

        public static void verifyOrder(WebDriver driver, String name){

           List<WebElement> nameList = driver.findElements(By.xpath("table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
           for (WebElement each:nameList){
               if (each.getText().equalsIgnoreCase(name)) {
                   Assert.assertTrue(true);
                   return;
               }
               Assert.fail("The name does not exist in the list! Verification failed!");
           }


        }


}
