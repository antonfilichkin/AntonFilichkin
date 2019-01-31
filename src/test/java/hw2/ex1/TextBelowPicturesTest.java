package hw2.ex1;

import base.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static base.Enums.HomePageData.TEST_PAGE_URL;
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
        WebDriver driver =  getWebDriver();
        driver.navigate().to(TEST_PAGE_URL.toString());

        String xPath = "//span[contains(@class, '" + icon + "')]//../following-sibling::span";
        assertEquals(driver.findElement(By.xpath(xPath)).getText(), text);

        driver.close();
    }
}