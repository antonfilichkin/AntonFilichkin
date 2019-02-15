package pages.hw3;

import enums.Benefits;
import enums.HomePageData;
import enums.TopMenuItems;
import enums.Users;
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

    public void openPage(HomePageData pageURL) {
        driver.get(pageURL.toString());
    }

    public void assertBrowserTitle(HomePageData expectedPageName) {
        assertEquals(driver.getTitle(), expectedPageName.toString());
    }

    public void login(Users user) {
        userIcon.click();
        userName.sendKeys(user.getLogin());
        userPass.sendKeys(user.getPass());
        loginButton.click();
    }

    public void assertUserName(Users userName) {
        assertTrue(userNameText.isDisplayed());
        assertEquals(userNameText.getText(), userName.getName().toUpperCase());
    }

    public void assertHeaderItems(TopMenuItems... expectedTopMenuItems) {
        int expectedSize = expectedTopMenuItems.length;
        assertEquals(navbarElements.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(navbarElements.get(i).isDisplayed());
            assertEquals(navbarElements.get(i).getText(), expectedTopMenuItems[i].toString());
        }
    }

    public void assertBenefitImages(Benefits... expectedBenefitImages) {
        int expectedSize = expectedBenefitImages.length;
        assertEquals(benefitIcons.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitIcons.get(i).isDisplayed());
            assertTrue(benefitIcons.get(i).findElement(By.cssSelector(expectedBenefitImages[i].getIcon())).isDisplayed());
        }
    }

    public void assertTextsUnderBenefitIcons(Benefits... expectedBenefitTexts) {
        int expectedSize = expectedBenefitTexts.length;
        assertEquals(benefitTexts.size(), expectedSize);

        for (int i = 0; i < expectedSize; ++i) {
            assertTrue(benefitTexts.get(i).isDisplayed());
            assertEquals(benefitTexts.get(i).getText(), expectedBenefitTexts[i].getText());
        }
    }

    public void assertMainHeaderTitle(HomePageData expectedHeaderTitle) {
        assertEquals(mainTitle.getText(), expectedHeaderTitle.toString());
    }

    public void assertMainHeaderText(HomePageData expectedHeaderText) {
        assertEquals(mainText.getText(), expectedHeaderText.toString());
    }

    public void assertIframeIsPresent() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public void switchBackFromIframe() {
        driver.switchTo().parentFrame();
    }

    public void assertEpamLogoIsPresent() {
        assertTrue(epamLogo.isDisplayed());
        System.out.println(epamLogo.toString());
    }

    public void assertSubHeaderText(HomePageData expectedSubHeaderText) {
        assertEquals(subHeader.getText(), expectedSubHeaderText.toString());
    }

    public void assertSubHeaderLink(HomePageData expectedSubHeaderURL) {
        assertEquals(subHeader.getAttribute("href"), expectedSubHeaderURL.toString());
    }

    public void assertLeftSectionIsPresent() {
        assertTrue(leftSection.isDisplayed());
    }

    public void assertFooterIsPresent() {
        assertTrue(footer.isDisplayed());
    }
}