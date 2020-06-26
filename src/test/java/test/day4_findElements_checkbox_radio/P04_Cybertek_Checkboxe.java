package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;


public class P04_Cybertek_Checkboxe {
    public static void main(String[] args) throws InterruptedException {
        //Practice:	Cybertek	Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        Thread.sleep(2000);

        WebElement checkhbox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkhbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        checkhbox1.isSelected();
            if (checkhbox1.isSelected()){
                System.out.println("checkbox #1 selected");
            }else {
                System.out.println("checkbox #1 NOT Selected");
            }

            if (checkhbox2.isSelected()){
                System.out.println("checkbox #2 selected");
            }else {
                System.out.println("checkbox #2 NOT Selected");
            }

        // 4.Click	checkbox	#1	to	select	it.
        // 5.Click	checkbox	#2	to	deselect	it.
        // 6.Confirm	checkbox	#1	is	SELECTED.
        // 7.Confirm	checkbox	#2	is	NOT

        checkhbox1.click();
            Thread.sleep(2000);
        checkhbox2.click();

        if (checkhbox1.isSelected()){
            System.out.println("checkbox #1 selected");
        }else {
            System.out.println("checkbox #1 NOT Selected");
        }

        if (checkhbox2.isSelected()){
            System.out.println("checkbox #2 selected");
        }else {
            System.out.println("checkbox #2 NOT Selected");
        }

        }






}
