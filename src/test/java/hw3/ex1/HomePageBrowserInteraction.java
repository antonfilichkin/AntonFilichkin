package hw3.ex1;

import base.Enums.Benefits;
import base.Enums.TopMenuItems;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static base.Enums.HomePageData.*;
import static base.Enums.Users.PITER_CHAILOVSKII;

public class HomePageBrowserInteraction {
    private HomePage homePage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = SeleniumBase.getWebDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod
    public void AfterTest() {
        driver.close();
    }

    @Test
    public void homePageContentTest() {
        // 1 Open test site by URL
        homePage.openPage(TEST_PAGE_URL);

        // 2 Assert Browser title
        homePage.assertBrowserTitle(TEST_PAGE_TITLE);

        // 3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        // 4 Assert User name in the left-top side of screen that user is logged in
        homePage.assertUserName(PITER_CHAILOVSKII);

        // 5 Assert Browser title
        homePage.assertBrowserTitle(TEST_PAGE_TITLE);

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.assertHeaderItems(TopMenuItems.values());

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.assertBenefitImages(Benefits.values());

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.assertTextsUnderBenefitIcons(Benefits.values());

        // 9 Assert a text of the main headers
        homePage.assertMainHeaderTitle(MAIN_HEADER_TITLE);
        homePage.assertMainHeaderText(MAIN_HEADER_TEXT);

        // 10 Assert that there is the iframe in the center of page
        homePage.assertIframeIsPresent();

        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe();
        homePage.assertEpamLogoIsPresent();

        // 12 Switch to original window back
        homePage.switchBackFromIframe();

        // 13 Assert a text of the sub header
        homePage.assertSubHeaderText(SUB_HEADER_TEXT);

        // 14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.assertSubHeaderLink(SUB_HEADER_URL);

        // 15 Assert that there is Left Section
        homePage.assertLeftSectionIsPresent();

        // 16 Assert that there is Footer
        homePage.assertFooterIsPresent();
    }
}