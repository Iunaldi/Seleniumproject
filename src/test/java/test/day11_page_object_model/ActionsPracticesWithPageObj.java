package test.day11_page_object_model;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

public class ActionsPracticesWithPageObj {

    @Test
    public void tc15_hover_over_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        HoversPage hoversPage =new HoversPage();
        Actions actions=new Actions(Driver.getDriver());

        actions.moveToElement(hoversPage.img1).perform();
        Assert.assertTrue(hoversPage.user1.isDisplayed());

        actions.moveToElement(hoversPage.img2).perform();
        Assert.assertTrue(hoversPage.user2.isDisplayed());

        actions.moveToElement(hoversPage.img3).perform();



        Assert.assertTrue(hoversPage.user3.isDisplayed());





    }
}
