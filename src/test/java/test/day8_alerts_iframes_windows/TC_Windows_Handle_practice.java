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

import java.sql.Time;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC_Windows_Handle_practice {

    //TC	#	:	Window	Handlepractice
    // 1.Create	a	new	class	called:	WindowHandlePractice
    // 2.Create	new	test	and	make	set	ups
    // 3.Go	to	:	http://practice.cybertekschool.com/windows
    // 4.Assert:	Title	is	“Practice”
    // 5.Click	to:	“Click	Here”text
    // 6.Switch	to	new	Window.
    // 7.Assert:	Title	is	“New	Window”

    WebDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.close();
    }

    @Test
    public void WindowHandling(){
        Assert.assertTrue(driver.getTitle().equals("Practice"));
        WebElement newWindowButton=driver.findElement(By.xpath("//a[.='Click Here']"));

        newWindowButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Set<String> windowsHandling =driver.getWindowHandles();
        for(String each:windowsHandling){
            driver.switchTo().window(each);
        }
        Assert.assertTrue(driver.getTitle().equals("New Window"));
    }
}
