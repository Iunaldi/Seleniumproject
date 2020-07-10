package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vyTrack_login {

    public vyTrack_login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement pessword;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgetPasswordLink;
}
