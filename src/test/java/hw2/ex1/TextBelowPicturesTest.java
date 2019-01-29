package hw2.ex1;

import base.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class TextBelowPicturesTest extends SeleniumBase {

    @DataProvider(parallel = true)
    private Object[][] TextsDataProvider() {
        return new Object[][] {
                {"icon-practise", "To include good practices\nand ideas from successful\nEPAM project"},
                {"icon-custom", "To be flexible and\ncustomizable"},
                {"icon-multi", "To be multiplatform"},
                {"icon-base", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "TextsDataProvider")
    public void textBelowPicturesTest(String icon, String text) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(25000, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        String xPath = "//span[contains(@class, '" + icon + "')]//../following-sibling::span";
        assertEquals(driver.findElement(By.xpath(xPath)).getText(), text);

        driver.close();
    }
}