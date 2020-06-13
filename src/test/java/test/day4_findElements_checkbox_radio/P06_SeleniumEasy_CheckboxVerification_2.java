package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P06_SeleniumEasy_CheckboxVerification_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);

        WebElement CheckAllButton=driver.findElement(By.xpath("//input[@value='Check All']"));

        if (CheckAllButton.isDisplayed()){
            System.out.println(" \" Check All\" button text is \" Check All \" ");
        }else{
            System.out.println(" \" Check All\" button text is \" Uncheck All \" ");
        }

        Thread.sleep(2000);
        CheckAllButton.click();
        Thread.sleep(2000);

        WebElement unCheckAllButton=driver.findElement(By.xpath("//input[@value='Uncheck All']"));

        if (unCheckAllButton.isDisplayed()){
            System.out.println(" \" Check All\" button text is \" Uncheck All \" ");
        }else{
            System.out.println(" \" Check All\" button text is \" Check All \" ");
        }


        Boolean checked=true;
        List<WebElement> checkAllButton = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//input[@type='checkbox']"));
        for (WebElement each:checkAllButton){
                System.out.println(each.isSelected());
                if (!each.isSelected()) {
                checked = checked && false;
            }
        }
        if (checked){
            System.out.println("All checked boxes are checked");
        }else{
            System.out.println("one or more of them are unchecked");     }










    }
}
