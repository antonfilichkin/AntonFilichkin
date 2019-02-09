package hw5.ex2;

import base.SelenideBase;
import hw4.Enums.SupportDropdownItems;
import hw4.Pages.DifferentElementsPage;
import hw4.Pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.Enums.Colors.YELLOW;
import static hw4.Enums.Elements.WATER;
import static hw4.Enums.Elements.WIND;
import static hw4.Enums.Metals.SELEN;
import static hw4.Enums.SupportDropdownItems.*;
import static hw4.Enums.URLs.DATES_PAGE;
import static hw4.Enums.URLs.DIFFERENT_ELEMENTS_PAGE;
import static hw4.Enums.URLs.HOME_PAGE;

public class ServicePageInterfaceCheckFail extends SelenideBase {
    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    private final String HomePageURL = HOME_PAGE.getUrl();

    @BeforeMethod(groups = {"JenkinsFailTest"})
    public void BeforeMethod() {
        // 1 Open test site by URL
        open(HomePageURL);
        homePage = page(HomePage.class);
        getWebDriver().manage().window().maximize(); //Force fullscreen
    }

    @AfterMethod(groups = {"JenkinsFailTest"})
    public void closeTest() {
        close();
    }

    @Test(groups = {"JenkinsFailTest"})
    public void homePageContentTest() {
        // 2 Assert Browser title
        homePage.assertBrowserTitle(DATES_PAGE);

        // 3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        // 4 Assert User name in the left-top side of screen that user is logged in
        homePage.assertUserName(PITER_CHAILOVSKII);

        // 5 Click on "Service" subcategory in the header and check that drop down contains options
        // "Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"	Elements exist
        SupportDropdownItems[] optionsToCheck = {
                SUPPORT, DATES, COMPLEX_TABLE, SIMPLE_TABLE, TABLE_WITH_PAGES, DIFFERENT_ELEMENTS};
        homePage.assertTopMenuServiceDropdownElements(optionsToCheck);

        // 6 Click on Service subcategory in the left section and check that drop down contains options
        // 	"Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements" Elements exist
        homePage.assertLeftSectionServiceDropdown(optionsToCheck);

        // 7 Open through the header menu Service -> Different Elements Page
        differentElementsPage = homePage.headerMenuServiceSelect(DIFFERENT_ELEMENTS);
        differentElementsPage.assertBrowserTitle(DIFFERENT_ELEMENTS_PAGE);

        // 8 Check interface on Different elements page, it contains all needed elements
        // 4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        differentElementsPage.checkInterface();

        // 9 Assert that there is Right Section
        differentElementsPage.assertRightSectionIsPresent();

        //10 Assert that there is Left Section
        differentElementsPage.assertLeftSectionIsPresent();

        //11 Select checkboxes Water, Wind
        differentElementsPage.selectCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.assertLog(WIND.valueChanged(true), WATER.valueChanged(true));

        //13 Select radio Selen Element
        differentElementsPage.selectRadioButtons(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        // Log row is displayed, radiobutton name and its status is corresponding to selected
        differentElementsPage.assertLog(SELEN.valueChanged());

        //15 Select in dropdown Yellow Element is selected
        differentElementsPage.selectDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.assertLog(YELLOW.valueChanged());

        //17 Unselect and assert checkboxes	Water, Wind	Elements are unchecked
        differentElementsPage.unselectCheckboxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.assertLog(WIND.valueChanged(false), WATER.valueChanged(false));
    }
}