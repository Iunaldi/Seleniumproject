package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//1. Open Chrome browser
// 2. Go to http://practice.cybertekschool.com/add_remove_elements
// 3. Click to “Add Element” button 50 times
// 4. Verify 50 “Delete” button is displayed after clicking.
// 5. Click to ALL “Delete” buttons to delete them.
// 6. Verify “Delete” button is NOT displayed after clicking.
// USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
// Hint: Need to use findElements method

public class P07_FindElements {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        Thread.sleep(1000);
        WebElement addElementButton=driver.findElement(By.xpath("//button[.=\"Add Element\"]"));

        for (int i=0;i<50;i++){
            Thread.sleep(500);
            addElementButton.click();
        }

        List<WebElement> deleteButtons=driver.findElements(By.xpath("//button[.=\"Delete\"]"));
        System.out.println(deleteButtons.size());
        if(deleteButtons.size()==50){
            System.out.println(" 50 “Delete” button is displayed");
        }else{
            System.out.println(" 50 “Delete” button is not displayed");
        }
            for (WebElement each : deleteButtons) {
                each.click();
                Thread.sleep(500);
            }

        deleteButtons=driver.findElements(By.xpath("//button[.=\"Delete\"]"));

            if(deleteButtons.size()==0){
                System.out.println("\"Delete\" button is NOT displayed");
            }else{
                System.out.println("\"Delete\" button is displayed");
            }




    }
}
