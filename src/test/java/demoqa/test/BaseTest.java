package demoqa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\IDEAProjects\\3 QAFOREVERYONE\\qaforeveryone-demoqa-test\\src\\test\\resources\\" +
                        "webdrivers\\chrome\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
