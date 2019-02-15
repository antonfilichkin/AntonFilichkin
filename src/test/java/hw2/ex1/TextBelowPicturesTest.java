package hw2.ex1;

import base.SeleniumBase;

import dataProviders.HeaderTextsDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static enums.HomePageData.TEST_PAGE_URL;
import static org.testng.Assert.assertEquals;

public class TextBelowPicturesTest extends SeleniumBase {
    @Test(dataProvider = "HeaderTextsDataProvider", dataProviderClass = HeaderTextsDataProvider.class)
    public void textBelowPicturesTest(String icon, String text) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_PAGE_URL.toString());

        String xPath = "//span[contains(@class, 'icon-" + icon + "')]//../following-sibling::span";
        assertEquals(driver.findElement(By.xpath(xPath)).getText(), text);

        driver.close();
    }
}