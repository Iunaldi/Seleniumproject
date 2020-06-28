package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_Iframe_practice {

    //TC #4: Iframe practice
    // 1.Create a new class called: IframePractice
    // 2.Create new test and make set ups
    // 3.Go to: http://practice.cybertekschool.com/iframe
    // 4.Assert: “Your content goes here.” Text is displayed.
    // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor

     WebDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();
    }

    @Test
    public void Iframe(){
        WebElement Iframe =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(Iframe);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Your content goes here.']")).isDisplayed());
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).isDisplayed());
    }
}
