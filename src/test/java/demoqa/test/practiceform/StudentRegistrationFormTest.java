package demoqa.test.practiceform;

import demoqa.test.BaseTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        final String[] GENDER = {"1", "Male"};

        final String DAY_OF_BIRTH = "15";
        final String MONTH_OF_BIRTH = "February";
        final String YEAR_OF_BIRTH = "1985";
        final String DATE_OF_BIRTH =
                DAY_OF_BIRTH + " " +
                        MONTH_OF_BIRTH + "," +
                        YEAR_OF_BIRTH;          //15 February,1985

        final String SUBJECT = "Maths";
        final String HOBBIES = "Sports";

        final String PATH_TO_FILE = "D:\\IDEAProjects\\3 QAFOREVERYONE\\qaforeveryone-demoqa-test" +
                "\\src\\test\\resources\\img\\cat.jpg";
        final String NAME_OF_FILE = new File(PATH_TO_FILE).getName();

        final String CURRENT_ADDRESS = "CA, San Francisco, 17 avn, 1";

        final String NAME_STATE = "NCR";
        final String NAME_CITY = "Delhi";
        final String STATE_AND_CITY = NAME_STATE + " " + NAME_CITY;


        WebElement firstName = driver.findElement(new By.ByCssSelector("input#firstName.mr-sm-2.form-control"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(new By.ByCssSelector("input#lastName.mr-sm-2.form-control"));
        lastName.sendKeys(LAST_NAME);

        WebElement userEmail = driver.findElement(new By.ByCssSelector("#userEmail"));
        userEmail.sendKeys(USER_EMAIL);

//        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper div.custom-control.custom-radio.custom-control-inline label"));
        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(" +
                GENDER[0] + ")"));

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

        // Subject
        //

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys(SUBJECT);

        WebElement choseSubject = driver.findElement(By.id("react-select-2-option-0"));
        choseSubject.click();

        // Hobbies
        WebElement hobbies = driver.findElement(By.cssSelector("div.custom-control.custom-checkbox.custom-control-inline"));
        hobbies.click();

        // Load a file
        WebElement loadFile = driver.findElement(By.id("uploadPicture"));
        loadFile.sendKeys(PATH_TO_FILE);

        // Set a current address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(CURRENT_ADDRESS);

        // State and City
        WebElement nameState = driver.findElement(By.id("react-select-3-input"));
        nameState.sendKeys(NAME_STATE);

        WebElement choseNameState = driver.findElement(By.id("react-select-3-option-0"));
        choseNameState.click();

        WebElement nameCity = driver.findElement(By.id("react-select-4-input"));
        nameCity.sendKeys(NAME_CITY);

        WebElement choseNameCity = driver.findElement(By.id("react-select-4-option-0"));
        choseNameCity.click();

        // Submit

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // Check the result
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        Map<String, String> tableResult = new HashMap<>();
        for (WebElement row : rows) {

            tableResult.put(
                    row.findElements(By.tagName("td")).get(0).getText(),
                    row.findElements(By.tagName("td")).get(1).getText()
            );
        }

        Assertions.assertThat(tableResult.get("Student Name")).isEqualTo(FIRST_NAME + " " + LAST_NAME);
        Assertions.assertThat(tableResult.get("Student Email")).isEqualTo(USER_EMAIL);
        Assertions.assertThat(tableResult.get("Gender")).isEqualTo(GENDER[1]);
        Assertions.assertThat(tableResult.get("Mobile")).isEqualTo(USER_NUMBER);

        Assertions.assertThat(tableResult.get("Subjects")).isEqualTo(SUBJECT);
        Assertions.assertThat(tableResult.get("Hobbies")).isEqualTo(HOBBIES);
        Assertions.assertThat(tableResult.get("Picture")).isEqualTo(NAME_OF_FILE);
        Assertions.assertThat(tableResult.get("Address")).isEqualTo(CURRENT_ADDRESS);
        Assertions.assertThat(tableResult.get("State and City")).isEqualTo(STATE_AND_CITY);

    }

}
