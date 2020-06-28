package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.attribute.standard.Chromaticity;
import java.util.concurrent.TimeUnit;

public class TC_JS_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();
    }

    @Test
    public void JS_Information_Alert(){
        WebElement JSAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        JSAlertButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']")).isDisplayed());
    }

    @Test
    public void JS_Confirmation_Alert(){
        WebElement JSAlertConfirmButton=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JSAlertConfirmButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='You clicked: Ok']")).isDisplayed());
    }

    @Test
    public void JS_Prompt_Alert(){
        WebElement JSPromptButton=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JSPromptButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='You entered: hello']")).isDisplayed());
    }
}
