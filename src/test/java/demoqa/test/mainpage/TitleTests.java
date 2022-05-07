package demoqa.test.mainpage;

// import org.assertj.core.api.Assertions;
import demoqa.config.BrowserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TitleTests {


    @Test(testName = "The title is exist")
    public void isExist() throws InterruptedException {
        String nameTitleExpected = "ToolsQA";

        System.setProperty("webdriver.chrome.driver", "D:/IDEAProjects/qaforeveryone-demoqa-test/src/test/resources/webdrivers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class);

        Dimension targetSize = new Dimension(
                browserConfig.dimensionWidth(),
                browserConfig.dimensionHeight()
        ); //width, int height
        driver.manage().window().setSize(targetSize);

        Thread.sleep(5000);
        String nameTitleActual = driver.getTitle();

        //Assertions.assertThat(nameTitleActual).isEqualTo(nameTitleExpected);
        Assert.assertEquals(nameTitleActual, nameTitleExpected);

        driver.quit();
    }

}
