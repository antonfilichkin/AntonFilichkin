package hw5.ex1;

import base.SelenideBase;
import enums.ServiceDropdownItems;
import pages.hw5.DifferentElementsPage;
import pages.hw5.HomePage;
import listeners.AllureAttachmentListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Colors.YELLOW;
import static enums.NatureElements.WATER;
import static enums.NatureElements.WIND;
import static enums.Metals.SELEN;
import static enums.ServiceDropdownItems.DIFFERENT_ELEMENTS;
import static enums.URLs.DIFFERENT_ELEMENTS_PAGE;
import static enums.URLs.HOME_PAGE;

@Feature("Jenkins tests")
@Story("Service Page Interface Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceCheck extends SelenideBase {
    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    private final String HomePageURL = HOME_PAGE.getUrl();

    @BeforeMethod(groups = {"JenkinsTest"})
    public void BeforeMethod() {
        // 1 Open test site by URL
        open(HomePageURL);
        homePage = page(HomePage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        getWebDriver().manage().window().maximize(); //Force fullscreen
    }

    @AfterMethod(groups = {"JenkinsTest"})
    public void closeTest() {
        close();
    }

    @Test(groups = {"JenkinsTest"})
    public void homePageContentTest() {
        // 2 Assert Browser title
        homePage.assertBrowserTitle(HOME_PAGE);

        // 3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        // 4 Assert User name in the left-top side of screen that user is logged in
        homePage.assertUserName(PITER_CHAILOVSKII);

        // 5 Click on "Service" subcategory in the header and check that drop down contains options
        // "Support, Dates, Complex Table, Simple Table, Tables With pages, Different NatureElements"	NatureElements exist
        // There are 8 elements in menu and in enum, and we have to check for only 6 of them,
        // my assumption was - what if it is dynamically created menu, and we have to check only for these 6?
        homePage.assertTopMenuServiceDropdownElements(ServiceDropdownItems.values());

        // 6 Click on Service subcategory in the left section and check that drop down contains options
        // 	"Support, Dates, Complex Table, Simple Table, Tables With pages, Different NatureElements" NatureElements exist
        homePage.assertLeftSectionServiceDropdown(ServiceDropdownItems.values());

        // 7 Open through the header menu Service -> Different NatureElements Page
        homePage.headerMenuServiceSelect(DIFFERENT_ELEMENTS);
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

        //17 Unselect and assert checkboxes	Water, Wind	NatureElements are unchecked
        differentElementsPage.unselectCheckboxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.assertLog(WIND.valueChanged(false), WATER.valueChanged(false));
    }
}