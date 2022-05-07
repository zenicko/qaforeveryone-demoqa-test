package demoqa.test.practiceform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StudentRegistrationFormTest {

    @Test
    void testRegistrationFormTestPositive() throws InterruptedException {
        //ElementClickInterceptedException

        final String FIRST_NAME = "Peter";
        final String LAST_NAME = "Ivanov";
        final String USER_EMAIL = "a@a.ru";
        final String USER_NUMBER = "1234567890";


        System.setProperty("webdriver.chrome.driver",
                "D:\\IDEAProjects\\3 QAFOREVERYONE\\qaforeveryone-demoqa-test\\src\\test\\resources\\" +
                        "webdrivers\\chrome\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(new By.ByCssSelector("input#firstName.mr-sm-2.form-control"));
        firstName.sendKeys(FIRST_NAME);

        WebElement lastName = driver.findElement(new By.ByCssSelector("input#lastName.mr-sm-2.form-control"));
        lastName.sendKeys(LAST_NAME);

        WebElement userEmail = driver.findElement(new By.ByCssSelector("#userEmail"));
        userEmail.sendKeys(USER_EMAIL);

        WebElement genderMale = driver.findElement(new By.ByCssSelector("#genterWrapper div.custom-control.custom-radio.custom-control-inline label"));
        genderMale.click();

        WebElement userNumber = driver.findElement(new By.ByCssSelector("#userNumber"));
        userNumber.sendKeys(USER_NUMBER);

        Thread.sleep(5000);
        driver.quit();
    }
}
