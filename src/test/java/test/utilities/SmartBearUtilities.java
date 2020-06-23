package test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtilities {

        public static void login(WebDriver driver) {
            WebElement imputUsername = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
            imputUsername.sendKeys("Tester");

            WebElement imputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
            imputPassword.sendKeys("test");

            WebElement loginButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
            loginButton.click();
        }


}
