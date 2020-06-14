package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P02_findElements_Apple {
    public static void main(String[] args) {

        //1.Open Chrome browser
        // 2.Go to https://www.apple.com
        // 3.Click to iPhone
        // 4.Print out the texts of all links
        // 5.Print out how many link is missing text
        // 6.Print out how many link has text
        // 7.Print out how many total lin


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        WebElement linkIphone =driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        linkIphone.click();

        List<WebElement> Textoflinks= driver.findElements(By.xpath("//a"));
        String text;
        int numOfWithText=0;
        int numOfWithoutText=0;

        for(WebElement each:Textoflinks){
           text=each.getText();
            System.out.println(text);

           if (!text.isEmpty()){
               System.out.println();
               numOfWithText++;
           }else{
               numOfWithoutText++;
           }
        }
        System.out.println("Number of links with text: "+numOfWithText);
        System.out.println("Number of links with text: "+numOfWithoutText);
        System.out.println("Total number of links with text: "+Textoflinks.size());









    }

}
