package hw1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class testSiteBrowserBehaviorTest extends SeleniumBase {

    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    // 17 Close Browser
    @AfterMethod
    public void AfterMethod() {
        driver.close();
    }

    @Test
    public void browserTest() {

        // 1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // 2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        // 4 Assert User name in the left-top side of screen that user is logged in
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");
        //assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getAttribute("innerHTML"), "Piter Chailovskii");

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerSectionItems = new ArrayList<>(driver.findElements(By.cssSelector(".navbar-nav.m-l8 > li")));
        assertEquals(4, headerSectionItems.size());
        assertTrue(headerSectionItems.get(0).isDisplayed());
        assertEquals("HOME", headerSectionItems.get(0).getText());
        assertTrue(headerSectionItems.get(1).isDisplayed());
        assertEquals("CONTACT FORM", headerSectionItems.get(1).getText());
        assertTrue(headerSectionItems.get(2).isDisplayed());
        assertEquals("SERVICE", headerSectionItems.get(2).getText());
        assertTrue(headerSectionItems.get(3).isDisplayed());
        assertEquals("METALS & COLORS", headerSectionItems.get(3).getText());

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.cssSelector(".icons-benefit.icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icons-benefit.icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icons-benefit.icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".icons-benefit.icon-base")).isDisplayed());
//        List<WebElement> indexPageImages = new ArrayList<>(driver.findElements(By.cssSelector(".icons-benefit")));
//        assertEquals(4, indexPageImages.size());
//        for (WebElement image : indexPageImages){
//            assertTrue(image.isDisplayed());
//        }

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        int textsQuantity = 4;
        String[] texts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        };

        List<WebElement> indexPageImagesTexts = new ArrayList<>(driver.findElements(By.cssSelector(".benefit-txt")));
        assertEquals(textsQuantity, indexPageImagesTexts.size());

        for (int i = 0; i < textsQuantity; ++i){
            assertTrue(indexPageImagesTexts.get(i).isDisplayed());
            assertEquals(texts[i], indexPageImagesTexts.get(i).getText());
        }

        // 9 Assert a text of the main headers
        WebElement mainTitle = driver.findElement(By.cssSelector("[name='main-title']"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement jdiText = driver.findElement(By.cssSelector("[name='jdi-text']"));
        assertTrue(jdiText.isDisplayed());
        assertEquals(jdiText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
                " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
                " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE" +
                " VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // 10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed();

        // 12 Switch to original window back
        driver.switchTo().parentFrame();

        // 13 Assert a text of the sub header
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/h3[2]/a")).getText(), "JDI GITHUB");

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.cssSelector("a[href='https://github.com/epam/JDI']")).getAttribute("href"),
                "https://github.com/epam/JDI");

        // 15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        // 16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());

        // 17 - @AfterMethod
    }
}