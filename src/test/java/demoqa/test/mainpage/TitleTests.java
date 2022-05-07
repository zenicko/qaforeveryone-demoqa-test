package demoqa.test.mainpage;

// import org.assertj.core.api.Assertions;

import demoqa.config.BrowserConfig;
import demoqa.test.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TitleTests extends BaseTest {

    @BeforeMethod
    public void open() throws InterruptedException {
        driver.get("https://demoqa.com/");
        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class);

        Dimension targetSize = new Dimension(
                browserConfig.dimensionWidth(),
                browserConfig.dimensionHeight()
        ); //width, int height
        driver.manage().window().setSize(targetSize);

        Thread.sleep(5000);
    }

    @Test(testName = "The title is exist")
    public void isExist() {
        String nameTitleExpected = "ToolsQA";
        String nameTitleActual = driver.getTitle();

        //Assertions.assertThat(nameTitleActual).isEqualTo(nameTitleExpected);
        Assert.assertEquals(nameTitleActual, nameTitleExpected);
    }

}
