package hw4.ex2;

import base.SelenideBase;
import hw4.Pages.DatesPage;
import hw4.Pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Enums.Users.PITER_CHAILOVSKII;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw4.Enums.Range2SliderThumbs.*;
import static hw4.Enums.SupportDropdownItems.*;
import static hw4.Enums.URLs.*;

public class DatesPageInterfaceCheck extends SelenideBase {
    private HomePage homePage;
    private DatesPage datesPage;

    private final String HomePageURL = HOME_PAGE.getUrl();

    @BeforeMethod(groups = {"JenkinsTest"})
    public void BeforeMethod() {
        // 1 Open test site by URL
        open(HomePageURL);
        homePage = page(HomePage.class);
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

        // 5 Open through the header menu Service -> Dates Page
        datesPage = homePage.headerMenuServiceSelect(DATES);
        datesPage.assertBrowserTitle(DATES_PAGE);

        // 6 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most right position.
        datesPage.setRange2Handle(FROM, 0);
        datesPage.setRange2Handle(TO, 100);

        // 7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        // There are 2 rows for "From" and "To" sliders with corresponding values
        datesPage.assertLog(TO.valueChanged(100), FROM.valueChanged(0));

        // 8 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most left position.
        datesPage.setRange2Handle(FROM, 0);
        datesPage.setRange2Handle(TO, 0);

        // 9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLog(TO.valueChanged(0), FROM.valueChanged(0));

        //10 Using drag-and-drop set Range sliders.
        // left sliders - the most rigth position, right slider - the most right position.
        datesPage.setRange2Handle(TO, 100);
        datesPage.setRange2Handle(FROM, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLog(FROM.valueChanged(100), TO.valueChanged(100));

        //12 Using drag-and-drop set Range sliders.	From = 30, To = 70
        datesPage.setRange2Handle(FROM, 30);
        // BUG - Dragging "From" slider from the same place as "To" slider - logs as "To" slider position.
        // Repeating step for correct log message
        datesPage.setRange2Handle(FROM, 30);
        datesPage.setRange2Handle(TO, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLog(TO.valueChanged(70), FROM.valueChanged(30));
        // OR assert variant with current site behavior
        //datesPage.assertLog(TO.valueChanged(70), TO.valueChanged(100));
    }
}