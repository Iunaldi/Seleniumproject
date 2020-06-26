package test.day8_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import test.utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

//PRACTICE #4: Method: verifyOrder•Create a method named verifyOrderin SmartBearUtils class.
// •Methodtakes WebDriver object and String(name).
// •Methodshould verify if given name exists in orders.
// •This method should simply accepts a name(String), and assert whether given name is in the list or not.
// •Create a new TestNG test to test if the method is working as expected.Practice
//
// #5: Method: printNamesAndCities
// •Create a method named printNamesAndCitiesin SmartBearUtils class.
// •Method takes WebDriver object.
// •This method should simply print all the names in the List of All Orders.
// •Create a new TestNG test to test if the method is working as expected.
// •Output should be like:•Name1: name , City1: city
// •Name2: name , City2: city



public class WebtablePractices {

    WebDriver driver;

   public void setUp() {

       driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       SmartBearUtilities.login(driver);
   }
}
