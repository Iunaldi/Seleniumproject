package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class P03_Apple_FindElements {
    public static void main(String[] args) throws InterruptedException {

        /*
    TC #02: FINDELEMENTS_APPLE
    1.Open Chrome browser
    2.Go to https://www.apple.com
    3.Click to iPhone
    4.Print out the texts of all links
    5.Print out how many link is missing text
    6.Print out how many link has text
    7.Print out how many total link
    */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        WebElement linkiPhone=driver.findElement(By.xpath("//a[@href='/iphone/']"));
        linkiPhone.click();

        List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
        Thread.sleep((2000));

        String textofAllLinks;
        int numOfTextLinks=0;
        int numOfnonTextLinks=0;
        for (WebElement each:AllLinks){
            textofAllLinks=each.getText();

            if(!textofAllLinks.isEmpty()) {
                System.out.println(textofAllLinks);
                numOfTextLinks++;
            }else{
                numOfnonTextLinks++;
            }
        }
        System.out.println("Number of links that has text :"+numOfTextLinks);
        System.out.println("Number of links that has no text :"+numOfnonTextLinks);
        System.out.println("Total Number of links :"+AllLinks.size());




    }




}
