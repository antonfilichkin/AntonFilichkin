package hw3.ex1;

import base.Enums.Benefits;
import base.Enums.HomePageData;
import base.Enums.TopMenuItems;
import base.Enums.Users;
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

    void openPage(HomePageData pageURL) {
        driver.get(pageURL.toString());
    }

    void assertBrowserTitle(HomePageData expectedPageName) {
        assertEquals(driver.getTitle(), expectedPageName.toString());
    }

    void login(Users user) {
        userIcon.click();
        userName.sendKeys(user.getLogin());
        userPass.sendKeys(user.getPass());
        loginButton.click();
    }

    void assertUserName(Users userName) {
        assertTrue(userNameText.isDisplayed());
        assertEquals(userNameText.getText(), userName.getName().toUpperCase());
    }

    void assertHeaderItems(TopMenuItems... expectedTopMenuItems) {
        int expectedSize = expectedTopMenuItems.length;
        assertEquals(navbarElements.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(navbarElements.get(i).isDisplayed());
            assertEquals(navbarElements.get(i).getText(), expectedTopMenuItems[i].toString());
        }
    }

    void assertBenefitImages(Benefits... expectedBenefitImages) {
        int expectedSize = expectedBenefitImages.length;
        assertEquals(benefitIcons.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitIcons.get(i).isDisplayed());
            assertTrue(benefitIcons.get(i).findElement(By.cssSelector(expectedBenefitImages[i].getIcon())).isDisplayed());
        }
    }

    void assertTextsUnderBenefitIcons(Benefits... expectedBenefitTexts) {
        int expectedSize = expectedBenefitTexts.length;
        assertEquals(benefitTexts.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitTexts.get(i).isDisplayed());
            assertEquals(benefitTexts.get(i).getText(), expectedBenefitTexts[i].getText());
        }
    }

    void assertMainHeaderTitle(HomePageData expectedHeaderTitle) {
        assertEquals(mainTitle.getText(), expectedHeaderTitle.toString());
    }

    void assertMainHeaderText(HomePageData expectedHeaderText) {
        assertEquals(mainText.getText(), expectedHeaderText.toString());
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

    void assertSubHeaderText(HomePageData expectedSubHeaderText) {
        assertEquals(subHeader.getText(), expectedSubHeaderText.toString());
    }

    void assertSubHeaderLink(HomePageData expectedSubHeaderURL) {
        assertEquals(subHeader.getAttribute("href"), expectedSubHeaderURL.toString());
    }

    void assertLeftSectionIsPresent() {
        assertTrue(leftSection.isDisplayed());
    }

    void assertFooterIsPresent() {
        assertTrue(footer.isDisplayed());
    }
}