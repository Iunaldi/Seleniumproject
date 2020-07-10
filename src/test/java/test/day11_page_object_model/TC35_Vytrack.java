package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC35_Vytrack {
    //TC#35: Vytrack forgot password page verificationsàTITLE andURL
    // 1. Go to https://qa3.vytrack.com
    // 2. Click to “Forgot your password?”link
    // 3. Verify title changed to expected
    // Expected: “Forgot Password”
    // 4. Verify url is as expected:
    // Expected: “https://qa3.vytrack.com/user/reset-request”
    // Note: Follow Page Object Model design pattern

    @Test
    public void VytrackForgotPassword_Title(){

        Driver.getDriver().get("https://qa3.vytrack.com");

        LoginPage loginpage =new LoginPage();

        loginpage.forgotPasswordLink.click();

        String expextedPage="Forgot Password";
        String actualPage = Driver.getDriver().getTitle();

        String expectedURL="https://qa3.vytrack.com/user/reset-request";
        String actualURL=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualPage.equals(expextedPage));
        Assert.assertTrue(actualURL.equals(expectedURL));

    }


    //C#36: Vytrack forgot password pageverificationàERROR MESSAGE
    // 1.Go to https://qa3.vytrack.com/user/reset-request
    // 2.Enter random username
    // 3. Click to request button
    // 4. Verifyerror message is displayed
    // 5. Verify error message text is as expected.
    //      Expected: There is no active user with username or email address “given text”.
    //      Note: Follow Page Object Model design pattern


    @Test
    public void VytrackForgotPassword_Error(){

        Driver.getDriver().get("https://qa3.vytrack.com");
        LoginPage loginpage =new LoginPage();
        loginpage.forgotPasswordLink.click();

        WebElement usernameInput=Driver.getDriver().findElement(By.id("prependedInput"));
        usernameInput.sendKeys("asdasdadsf");

        WebElement requestButton=Driver.getDriver().findElement(By.xpath("//button"));
        requestButton.click();

        WebElement errorMessage=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());





    }
}
