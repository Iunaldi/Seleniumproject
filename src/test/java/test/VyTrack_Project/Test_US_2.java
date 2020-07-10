package test.VyTrack_Project;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

public class Test_US_2 {

    WebDriver driver= Driver.getDriver();


    @Test
    public void Login() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));

        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("_submit")).click();

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"));

        Actions action = new Actions(Driver.getDriver());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"))).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("All - Car - Entities - System - Car - Entities - System"));

        driver.findElement(By.xpath("//a[@title='Create Car']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().equals("Create Car - Entities - System - Car - Entities - System"));

        Faker fake=new Faker();
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_LicensePlate')]")).sendKeys(fake.code().asin());
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Tags_5')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Driver')]")).sendKeys(fake.name().firstName());
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Location')]")).sendKeys(fake.country().name());
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_ChassisNumber')]")).sendKeys(fake.code().ean8());
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_ModelYear')]")).sendKeys("2019");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_LastOdometer')]")).sendKeys(""+fake.number().numberBetween(0,400000));
        //driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_ImmatriculationDate')]")).sendKeys("Jul 7, 2005");
        //driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_FirstContractDate')]")).sendKeys("Jul 7, 2015");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_CatalogValue')]")).sendKeys("400000");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_SeatsNumber')]")).sendKeys("6");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_DoorsNumber')]")).sendKeys("5");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Color')]")).sendKeys(fake.color().name());
        driver.findElement(By.xpath("//span[contains(@class,'select2-chosen')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//option[.='Manual']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//option[.='Diesel']")).click();

        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_CO2Emissions')]")).sendKeys("120");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Horsepower')]")).sendKeys("200");
        driver.findElement(By.xpath("//input[contains(@id,'custom_entity_type_Power')]")).sendKeys("400");

        driver.findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//div[contains(@id,'ui-id')]//input[@type='checkbox'])[8]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();


        driver.findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//div[contains(@id,'ui-id')]//input[@type='checkbox'])[9]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text edit-button main-group']")).click();

        ///Assert.assertTrue(driver.getTitle().contains("Entities - System - Car - Entities - System"));

        driver.findElement(By.xpath("//a[@data-action='cancel']")).click();
        driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][2]//td[2]")).click();

        driver.findElement(By.xpath("//a[@title='Add an event to this record']")).click();

        driver.findElement(By.xpath("//fieldset[@class='form form-horizontal']//input[contains(@id,'oro_calendar_event_form_title')]")).sendKeys("Happy");

        driver.findElement(By.xpath("//div[@class='form-actions widget-actions']//button[@class='btn btn-primary']")).click();


    }


}
