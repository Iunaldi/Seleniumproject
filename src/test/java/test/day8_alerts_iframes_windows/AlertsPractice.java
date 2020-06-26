package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get((" http://practice.cybertekschool.com/javascript_alerts"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

   @Test
    public void p1_information_alert_test(){
       WebElement infoButton=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
       infoButton.click();
       Alert alert=driver.switchTo().alert();
       alert.accept();

       WebElement result = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']"));
       Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void confirmation_alert_test(){
        WebElement confirmationAlertButton=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmationAlertButton.click();
        Alert alert =driver.switchTo().alert();
        alert.dismiss();
        WebElement result=driver.findElement(By.xpath("//p[.='You clicked: Cancel']"));
        Assert.assertTrue(result.isDisplayed());

    }

    @Test
    public void prompt(){
        WebElement prompt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        prompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Ok. You and go!");
        alert.accept();

        WebElement result=driver.findElement(By.xpath("//p[contains(.,'You entered:')]"));
        String actualResul=result.getText();
        String expectedResult="You entered: Ok. You and go!";
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Assert.assertTrue(actualResul.equals(expectedResult));

    }
}
