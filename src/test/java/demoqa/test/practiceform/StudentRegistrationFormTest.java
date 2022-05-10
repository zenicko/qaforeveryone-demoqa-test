package demoqa.test.practiceform;

import demoqa.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationFormTest extends BaseTest {

    @BeforeMethod
    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    void testRegistrationFormTestPositive() throws InterruptedException {

        final String FIRST_NAME = "Peter";
        final String LAST_NAME = "Ivanov";
        final String USER_EMAIL = "a@a.ru";
        final String USER_NUMBER = "1234567890";
        final String GENDER = "1";

        final String DAY_OF_BIRTH = "15";
        final String MONTH_OF_BIRTH = "February";
        final String YEAR_OF_BIRTH = "1985";

        WebElement firstName = driver.findElement(new By.ByCssSelector("input#firstName.mr-sm-2.form-control"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(new By.ByCssSelector("input#lastName.mr-sm-2.form-control"));
        lastName.sendKeys(LAST_NAME);

        WebElement userEmail = driver.findElement(new By.ByCssSelector("#userEmail"));
        userEmail.sendKeys(USER_EMAIL);

//        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper div.custom-control.custom-radio.custom-control-inline label"));
        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(" +
                GENDER + ")"));

        // #genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)
        // #genterWrapper div.custom-control.custom-radio.custom-control-inline label
        genderMale.click();

        WebElement userNumber = driver.findElement(new By.ByCssSelector("#userNumber"));
        userNumber.sendKeys(USER_NUMBER);

        // 12 Feb 1980
        WebElement dateOfBirth = driver.findElement(By.cssSelector("input#dateOfBirthInput.form-control"));
//        WebElement dataOfBirth1 = driver.findElement(By.id("#dateOfBirthInput"));

// Способ очистки поля
//        dateOfBirth.click();
//        dateOfBirth.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
//        dateOfBirth.sendKeys(DATE_OF_BIRTH);

        dateOfBirth.click();
//        WebElement day09 = driver.findElements(By.className("react-datepicker__day--009")).get(0);
//        day09 = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]"));
////        WebElement _day09 = driver.findElement(By.className("div[class^=\'react-datepicker__day--009\']"));
////
//        day09.click();
//
        Thread.sleep(500);

        Select selectYear = new Select(driver.findElement(By.cssSelector("select.react-datepicker__year-select")));
        selectYear.selectByVisibleText(YEAR_OF_BIRTH);

        Select selectMonth = new Select(driver.findElement(By.cssSelector("select.react-datepicker__month-select")));
        selectMonth.selectByVisibleText(MONTH_OF_BIRTH);

        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day--0" + DAY_OF_BIRTH));
        day.click();

    }


}
