package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;


import java.util.List;

public class P03_Apple_FindElements {
    public static void main(String[] args) throws InterruptedException {

        //TC #03: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        // 2.Go to https://www.apple.com
        // 3.Click to all of the headers one by one
        //     a.Mac, iPad, iPhone, Watch, TV, Music, Support
        //4.Printout how many links on each pagewiththe titles of the pages
        //5.Loop through all
        //6.Print out how many link is missing textTOTAL
        //7.Print out how many link has textTOTAL
        //8.Print out how many total linkTOTAL


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        List<WebElement> links =driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        int numOfWithText=0;
        int numOfWithoutText=0;

            for (int i=1;i<8;i++) {
                links.get(i).click();
                Thread.sleep(2000);

                List<WebElement> Textoflinks= driver.findElements(By.xpath("//body//a"));

                System.out.println("Number of links on page"+driver.getTitle() +" "+Textoflinks.size());
                String text;


                for(WebElement each:Textoflinks){
                    text=each.getText();
                    if (!text.isEmpty()){
                        numOfWithText++;
                    }else{
                        numOfWithoutText++;
                    }
                }

                driver.navigate().back();
                links=driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));


            }
            System.out.println("Number of links with text: "+numOfWithText);
            System.out.print("  Number of links with text: "+numOfWithoutText);

        }
    }





