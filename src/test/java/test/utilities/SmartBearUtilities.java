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


        //Practice #5: Method: printNamesAndCities
        // •Create a method named printNamesAndCitiesin SmartBearUtils class.
        // •Method takes WebDriver object.
        // •This method should simply print all the names in the List of All Orders.
        // •Create a new TestNG test to test if the method is working as expected.
        // •Output should be like:
        // •Name1: name , City1: city
        // •Name2: name , City2: city

        public static void printNamesAndCitiesin(WebDriver driver){

        List<WebElement> citiesList =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (int i=0;i<citiesList.size();i++){
            System.out.println("Name "+i+": "+nameList.get(i).getText()+ " City "+i+": "+citiesList.get(i).getText());
        }
    }


}
