package hw3.ex1;

import base.Enums.Benefits;
import base.Enums.TopMenuItems;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static base.Enums.HomePageData.*;
import static base.Enums.Users.PITER_CHAILOVSKII;

// TODO What is the reason of this inheritance ?
// TODO You are going to create WD twice..
public class HomePageBrowserInteraction extends SeleniumBase {
    private HomePage homePage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = getWebDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod
    public void AfterTest() {
        driver.close();
    }

    @Test
    public void homePageContentTest() {
        // TODO In general, your approach is OK, but it will be better to
        // TODO parametrise PO methods by ENUM itself instead of String

        // 1 Open test site by URL
        homePage.openPage(TEST_PAGE_URL.toString());

        // 2 Assert Browser title
        homePage.assertBrowserTitle(TEST_PAGE_TITLE.toString());

        // 3 Perform login
        // TODO You can parametrise this method by Users enum, this will improve readability and reliability
        homePage.login(PITER_CHAILOVSKII.getLogin(), PITER_CHAILOVSKII.getPass());

        // 4 Assert User name in the left-top side of screen that user is logged in
        homePage.assertUserName(PITER_CHAILOVSKII.getName().toUpperCase());

        // 5 Assert Browser title
        homePage.assertBrowserTitle(TEST_PAGE_TITLE.toString());

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.assertHeaderItems(TopMenuItems.getAll());

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.assertBenefitImages(Benefits.getAllIcons());

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.assertTextsUnderBenefitIcons(Benefits.getAllTexts());

        // 9 Assert a text of the main headers
        homePage.assertMainHeaderTitle(MAIN_HEADER_TITLE.toString());
        homePage.assertMainHeaderText(MAIN_HEADER_TEXT.toString());

        // 10 Assert that there is the iframe in the center of page
        homePage.assertIframeIsPresent();

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe();
        homePage.assertEpamLogoIsPresent();

        // 12 Switch to original window back
        homePage.switchBackFromIframe();

        // 13 Assert a text of the sub header
        homePage.assertSubHeaderText(SUB_HEADER_TEXT.toString());

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.assertSubHeaderLink(SUB_HEADER_URL.toString());

        // 15 Assert that there is Left Section
        homePage.assertLeftSectionIsPresent();

        // 16 Assert that there is Footer
        homePage.assertFooterIsPresent();
    }
}