package demoqa.test.practiceform;

import demoqa.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationFormTest extends BaseTest {

    @BeforeMethod
    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    void testRegistrationFormTestPositive() {

        final String FIRST_NAME = "Peter";
        final String LAST_NAME = "Ivanov";
        final String USER_EMAIL = "a@a.ru";
        final String USER_NUMBER = "1234567890";

        WebElement firstName = driver.findElement(new By.ByCssSelector("input#firstName.mr-sm-2.form-control"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(new By.ByCssSelector("input#lastName.mr-sm-2.form-control"));
        lastName.sendKeys(LAST_NAME);

        WebElement userEmail = driver.findElement(new By.ByCssSelector("#userEmail"));
        userEmail.sendKeys(USER_EMAIL);

//        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper div.custom-control.custom-radio.custom-control-inline label"));
        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)"));
        // #genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)
        // #genterWrapper div.custom-control.custom-radio.custom-control-inline label
        genderMale.click();

        WebElement userNumber = driver.findElement(new By.ByCssSelector("#userNumber"));
        userNumber.sendKeys(USER_NUMBER);

    }


}
