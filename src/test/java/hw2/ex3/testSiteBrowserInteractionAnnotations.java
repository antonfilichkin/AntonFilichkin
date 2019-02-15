package hw2.ex3;

import enums.Benefits;
import enums.TopMenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static enums.HomePageData.*;
import static enums.HomePageSelectors.*;
import static enums.Users.*;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class testSiteBrowserInteractionAnnotations {

    private WebDriver driver;

    @BeforeSuite
    public void BeforeSuite() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @AfterSuite
    public void AfterSuit() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void homePageContentTest() {
        // 1 Open test site by URL
        driver.navigate().to(TEST_PAGE_URL.toString());

        // 2 Assert Browser title
        assertEquals(driver.getTitle(), TEST_PAGE_TITLE.toString());

        // 3 Perform login
        driver.findElement(By.cssSelector(USER_ICON_CSS.toString())).click();
        driver.findElement(By.cssSelector(USER_NAME_INPUT_CSS.toString())).sendKeys(PITER_CHAILOVSKII.getLogin());
        driver.findElement(By.cssSelector(USER_PASS_INPUT_CSS.toString())).sendKeys(PITER_CHAILOVSKII.getPass());
        driver.findElement(By.cssSelector(LOGIN_BUTTON_CSS.toString())).click();

        // 4 Assert User name in the left-top side of screen that user is logged in
        WebElement element = driver.findElement(By.cssSelector(USER_NAME_TEXT_CSS.toString()));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), PITER_CHAILOVSKII.getName().toUpperCase());

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), TEST_PAGE_TITLE.toString());

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        int expected_items = TopMenuItems.values().length;
        List<WebElement> topMenuItemsActual = driver.findElements(By.cssSelector(NAVBAR_ELEMENTS_CSS.toString()));
        assertEquals(topMenuItemsActual.size(), expected_items);

        TopMenuItems[] topMenuItemsExpected = TopMenuItems.values();
        for (int i = 0; i < expected_items; ++i) {
            assertTrue(topMenuItemsActual.get(i).isDisplayed());
            assertEquals(topMenuItemsActual.get(i).getText(), topMenuItemsExpected[i].toString());
        }

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        expected_items = Benefits.getSize();
        List<WebElement> benefitsImages = driver.findElements(By.cssSelector(BENEFIT_ICONS_CSS.toString()));
        assertEquals(benefitsImages.size(), expected_items);

        Benefits[] benefits = Benefits.values();
        for (int i = 0; i < expected_items; ++i) {
            assertTrue(benefitsImages.get(i).findElement(By.cssSelector(benefits[i].getIcon())).isDisplayed());
        }

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector(BENEFIT_TEXTS_CSS.toString()));
        assertEquals(benefitsTexts.size(), expected_items);

        for (int i = 0; i < expected_items; ++i) {
            assertTrue(benefitsTexts.get(i).isDisplayed());
            assertEquals(benefitsTexts.get(i).getText(), benefits[i].getText());
        }

        // 9 Assert a text of the main headers
        assertEquals(driver.findElement(By.cssSelector(MAIN_TITLE_CSS.toString())).getText(), MAIN_HEADER_TITLE.toString());
        assertEquals(driver.findElement(By.cssSelector(MAIN_TEXT.toString())).getText(), MAIN_HEADER_TEXT.toString());

        // 10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector(IFRAME_CSS.toString())).isDisplayed());

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(IFRAME_NAME.toString());
        assertTrue(driver.findElement(By.cssSelector((EPAM_LOGO_CSS.toString()))).isDisplayed());

        // 12 Switch to original window back
        driver.switchTo().parentFrame();

        // 13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(SUB_HEADER_CSS.toString()));
        assertEquals(subHeader.getText(), SUB_HEADER_TEXT.toString());

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), SUB_HEADER_URL.toString());

        // 15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(LEFT_SECTION_CSS.toString())).isDisplayed());

        // 16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector(FOOTER_CSS.toString())).isDisplayed());
    }
}