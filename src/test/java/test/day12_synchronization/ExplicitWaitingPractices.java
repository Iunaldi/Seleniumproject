package test.day12_synchronization;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitingPractices {

    //TC#40: Dynamically Loaded Page Elements 7
    // 1.Go to http://practice.cybertekschool.com/dynamic_loading/7
    // 2.Wait until title is “Dynamic Title”
    // 3.Assert : Message “Done” is displayed.
    // 4.Assert : Image is displayed.

    @Test
    public void tc40_dynamic_title_test(){
        String url="http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

        Loading7Page loading7Page=new Loading7Page();

        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());


        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());


    }

    //TC#41: Dynamically Loaded Page Elements 1
    // 1.Go to http://practice.cybertekschool.com/dynamic_loading/1
    // 2.Click to start
    // 3.Wait until loading bar disappears
    // 4.Assert username inputboxis displayed
    // 5.Enter username: tomsmith
    // 6.Enter password: incorrectpassword
    // 7.Click to Submit button
    // 8.Assert “Your username is invalid!” text is displayed
    @Test
    public void tc41_dynamic_form_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page=new Loading1Page();

        WebDriverWait driverWait=new WebDriverWait(Driver.getDriver(),10);

        loading1Page.startButton.click();

        driverWait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingImg));
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed(), "Username input box is not displayed!");

        loading1Page.usernameInput.sendKeys("tomsmith");
        loading1Page.passwordInput.sendKeys("incorrectpassword");
        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());






    }




}
