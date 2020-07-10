package pages;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Reader;

public class Reusable {
    public static void clickOnDesiredLink(String link) throws InterruptedException {
        //String link = ConfigurationReader.getProperty("desiredLink");
        formyProjectPage page = new formyProjectPage();
        for (WebElement each : page.links) {
            if (each.getText().equals(link)) {
                Thread.sleep(3000);
                each.click();
                break;
            }
        }
    }
    @Test
    public void test3(){
        System.out.println(Reader.cagir("testdata"));
    }
}
