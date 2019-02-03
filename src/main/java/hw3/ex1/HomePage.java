package hw3.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {
    @FindBy(css = "[id='user-icon']")
    private WebElement userIcon;

    @FindBy(css = "[id='name']")
    private WebElement userName;

    @FindBy(css = "[id='password']")
    private WebElement userPass;

    @FindBy(css = "[id='login-button']")
    private WebElement loginButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userNameText;

    @FindBy(css = ".navbar-nav.m-l8 > li")
    private List<WebElement> navbarElements;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-icon + .benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainText;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "img[id = 'epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = ".uui-side-bar")
    private WebElement leftSection;

    @FindBy(css = "h3.text-center > a")
    private WebElement subHeader;

    @FindBy(css = ".footer-bg")
    private WebElement footer;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    void openPage(String pageURL) {
        driver.get(pageURL);

    }

    void assertBrowserTitle(String pageName) {
        assertEquals(driver.getTitle(), pageName);
    }

    void login(String name, String password) {
        userIcon.click();
        userName.sendKeys(name);
        userPass.sendKeys(password);
        loginButton.click();
    }

    void assertUserName(String userName) {
        assertTrue(userNameText.isDisplayed());
        assertEquals(userNameText.getText(), userName);
    }

    void assertHeaderItems(String[] expectedItemsTexts) {
        int expectedSize = expectedItemsTexts.length;
        assertEquals(navbarElements.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(navbarElements.get(i).isDisplayed());
            assertEquals(navbarElements.get(i).getText(), expectedItemsTexts[i]);
        }
    }

    void assertBenefitImages(String[] expectedBenefitImages) {
        int expectedSize = expectedBenefitImages.length;
        assertEquals(benefitIcons.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitIcons.get(i).isDisplayed());
            assertTrue(benefitIcons.get(i).findElement(By.cssSelector(expectedBenefitImages[i])).isDisplayed());
        }
    }

    void assertTextsUnderBenefitIcons(String[] expectedBenefitTexts) {
        int expectedSize = expectedBenefitTexts.length;
        assertEquals(benefitTexts.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitTexts.get(i).isDisplayed());
            assertEquals(benefitTexts.get(i).getText(), expectedBenefitTexts[i]);
        }
    }

    void assertMainHeaderTitle(String expectedHeaderTitle) {
        assertEquals(mainTitle.getText(), expectedHeaderTitle);
    }

    void assertMainHeaderText(String expectedHeaderText) {
        assertEquals(mainText.getText(), expectedHeaderText);
    }

    void assertIframeIsPresent() {
        assertTrue(iframe.isDisplayed());
    }

    void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    void switchBackFromIframe() {
        driver.switchTo().parentFrame();
    }

    void assertEpamLogoIsPresent() {
        assertTrue(epamLogo.isDisplayed());
        System.out.println(epamLogo.toString());
    }

    void assertSubHeaderText(String text) {
        assertEquals(subHeader.getText(), text);
    }

    void assertSubHeaderLink(String subHeaderURL) {
        assertEquals(subHeader.getAttribute("href"), subHeaderURL);
    }

    void assertLeftSectionIsPresent() {
        assertTrue(leftSection.isDisplayed());
    }

    void assertFooterIsPresent() {
        assertTrue(footer.isDisplayed());
    }
}