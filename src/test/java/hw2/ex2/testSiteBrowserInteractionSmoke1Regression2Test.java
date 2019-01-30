package hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class testSiteBrowserInteractionSmoke1Regression2Test extends SeleniumBase {

    @Test(groups = {"Smoke"})
    public void homePageContentTestSmoke1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        int headerItems = 4;
        String[] headerItemsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        List<WebElement> headerSectionItems = driver.findElements(By.cssSelector(".navbar-nav.m-l8 > li"));
        assertEquals(headerSectionItems.size(), headerItems);

        for (int i = 0; i < headerItems; ++i){
            assertTrue(headerSectionItems.get(i).isDisplayed());
            assertEquals(headerSectionItems.get(i).getText(), headerItemsTexts[i]);
        }

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsImages = driver.findElements(By.cssSelector(".benefit > .benefit-icon"));
        assertEquals(benefitsImages.size(), 4);

        String[] benefitsImagesCssSelectors = {".icon-practise", ".icon-custom", ".icon-multi", ".icon-base"};
        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsImages.get(i).findElement(By.cssSelector(benefitsImagesCssSelectors[i])).isDisplayed());
        }

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector(".benefit-icon + span"));
        assertEquals(benefitsTexts.size(), 4);

        String[] benefitImagesExpectedTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};

        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(benefitsTexts.get(i).getText(), benefitImagesExpectedTexts[i]);
        }

        // 9 Assert a text of the main headers
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector("p.main-txt")).getText(), "LOREM IPSUM DOLOR SIT AMET," +
                " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
                " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT" +
                " DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // 10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(("img[id = 'epam_logo']"))).isDisplayed());

        // 12 Switch to original window back
        driver.switchTo().parentFrame();

        // 13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center > a"));
        assertEquals(subHeader.getText(), "JDI GITHUB");

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        // 15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        // 16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());

        driver.close();
    }

    @Test(groups = {"Regression"})
    public void homePageContentTestRegression1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        int headerItems = 4;
        String[] headerItemsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        List<WebElement> headerSectionItems = driver.findElements(By.cssSelector(".navbar-nav.m-l8 > li"));
        assertEquals(headerSectionItems.size(), headerItems);

        for (int i = 0; i < headerItems; ++i){
            assertTrue(headerSectionItems.get(i).isDisplayed());
            assertEquals(headerSectionItems.get(i).getText(), headerItemsTexts[i]);
        }

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsImages = driver.findElements(By.cssSelector(".benefit > .benefit-icon"));
        assertEquals(benefitsImages.size(), 4);

        String[] benefitsImagesCssSelectors = {".icon-practise", ".icon-custom", ".icon-multi", ".icon-base"};
        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsImages.get(i).findElement(By.cssSelector(benefitsImagesCssSelectors[i])).isDisplayed());
        }

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector(".benefit-icon + span"));
        assertEquals(benefitsTexts.size(), 4);

        String[] benefitImagesExpectedTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};

        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(benefitsTexts.get(i).getText(), benefitImagesExpectedTexts[i]);
        }

        // 9 Assert a text of the main headers
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector("p.main-txt")).getText(), "LOREM IPSUM DOLOR SIT AMET," +
                " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
                " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT" +
                " DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // 10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(("img[id = 'epam_logo']"))).isDisplayed());

        // 12 Switch to original window back
        driver.switchTo().parentFrame();

        // 13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center > a"));
        assertEquals(subHeader.getText(), "JDI GITHUB");

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        // 15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        // 16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());

        driver.close();
    }

    @Test(groups = {"Regression"})
    public void homePageContentTestRegression2() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        int headerItems = 4;
        String[] headerItemsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        List<WebElement> headerSectionItems = driver.findElements(By.cssSelector(".navbar-nav.m-l8 > li"));
        assertEquals(headerSectionItems.size(), headerItems);

        for (int i = 0; i < headerItems; ++i){
            assertTrue(headerSectionItems.get(i).isDisplayed());
            assertEquals(headerSectionItems.get(i).getText(), headerItemsTexts[i]);
        }

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsImages = driver.findElements(By.cssSelector(".benefit > .benefit-icon"));
        assertEquals(benefitsImages.size(), 4);

        String[] benefitsImagesCssSelectors = {".icon-practise", ".icon-custom", ".icon-multi", ".icon-base"};
        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsImages.get(i).findElement(By.cssSelector(benefitsImagesCssSelectors[i])).isDisplayed());
        }

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector(".benefit-icon + span"));
        assertEquals(benefitsTexts.size(), 4);

        String[] benefitImagesExpectedTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};

        for (int i = 0; i < 4; ++i) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(benefitsTexts.get(i).getText(), benefitImagesExpectedTexts[i]);
        }

        // 9 Assert a text of the main headers
        assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector("p.main-txt")).getText(), "LOREM IPSUM DOLOR SIT AMET," +
                " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
                " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT" +
                " DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        // 10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector(("img[id = 'epam_logo']"))).isDisplayed());

        // 12 Switch to original window back
        driver.switchTo().parentFrame();

        // 13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center > a"));
        assertEquals(subHeader.getText(), "JDI GITHUB");

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        // 15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        // 16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());

        driver.close();
    }
}