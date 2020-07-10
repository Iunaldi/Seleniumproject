package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class ActionsTest {

    public void hover_over_test1(){
        Driver.getDriver().get("https://www.amazon.com");
        Actions action = new Actions(Driver.getDriver());

        WebElement languageOption =Driver.getDriver().findElement(By.id("icp-nav-flyout"));
        action.moveToElement(languageOption).perform();

    }

    @Test
        public void tc15_hover_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Actions actions=new Actions(Driver.getDriver());

        WebElement image1=Driver.getDriver().findElement(By.xpath("//div[@class='figure']"));
        actions.moveToElement(image1).perform();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement name1=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(name1.isDisplayed());

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement image2=Driver.getDriver().findElement(By.xpath("//div[@class='figure']"));
        actions.moveToElement(image2).perform();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement name2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(name2.isDisplayed());

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement image3=Driver.getDriver().findElement(By.xpath("//div[@class='figure']"));
        actions.moveToElement(image3).perform();
        WebElement name3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        Assert.assertTrue(name3.isDisplayed());







    }
}
