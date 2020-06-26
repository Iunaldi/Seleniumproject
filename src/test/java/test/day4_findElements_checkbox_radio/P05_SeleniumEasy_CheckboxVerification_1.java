package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;


public class P05_SeleniumEasy_CheckboxVerification_1 {
    public static void main(String[] args) throws InterruptedException{
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed.

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);

        WebElement text=driver.findElement(By.xpath("//div[.=\"Success - Check box is checked\"]"));
        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));

        if (text.isDisplayed()){
            System.out.println(" “Success–Check box is checked” message is displayed.");
        }else{
            System.out.println(" “Success–Check box is checked” message is NOT displayed.");
        }

        checkBox.click();

        if (text.isDisplayed()&&checkBox.isSelected()){
            System.out.println(" “Success–Check box is checked” message is displayed and ckeck box is selected.");
        }else{
            System.out.println(" “Success–Check box is checked” message is NOT ckeck box is not  selected displayed.");
        }





    }
}
