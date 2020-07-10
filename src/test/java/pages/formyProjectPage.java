package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class formyProjectPage {

    public formyProjectPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-lg']")
    public List<WebElement> links;

    @BeforeTest
    public void page() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("formy_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void Test1() throws InterruptedException {
        Reusable.clickOnDesiredLink(ConfigurationReader.getProperty("desiredLink"));
    }






//    @Test
//    public void clickOnDesiredLink() throws InterruptedException {
//        String link= ConfigurationReader.getProperty("desiredLink");
//        for(WebElement each:links){
//            if(each.getText().equals(link)){
//                Thread.sleep(3000);
//                each.click();
//                break;
//            }
//        }
//
//
//    }


}

