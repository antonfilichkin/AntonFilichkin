package pages.hw5;

import enums.ServiceDropdownItems;
import enums.Users;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;

public abstract class BaseNavigation {
    @FindBy(css = "title")
    private SelenideElement pageTitle;

    // ----- HEADER -----
    @FindBy(css = "[id='user-icon']")
    private SelenideElement userIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userNameInput;

    @FindBy(css = "[id='password']")
    private SelenideElement userPassInput;

    @FindBy(css = "[id='login-button']")
    private SelenideElement loginButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userNameText;

    @FindBy(css = ".m-l8 > .dropdown")
    private SelenideElement headerMenuServiceDropdown;

    @FindBy(css = ".m-l8 > .dropdown li")
    private ElementsCollection headerMenuServiceDropdownItems;

    @FindBy(css = ".m-l8  a[href^='different']")
    private SelenideElement headerMenuServiceDropdownDifferentElements;

    @FindBy(css = ".m-l8  a[href^='dates']")
    private SelenideElement headerMenuServiceDropdownDates;

    // ----- FOOTER -----
    @FindBy(css = ".footer-bg")
    private SelenideElement footer;

    // ----- LEFT MENU -----
    @FindBy(css = ".uui-side-bar")
    private SelenideElement leftSection;

    @FindBy(css = ".sidebar-menu > [index='3']")
    private SelenideElement leftMenuServiceDropdown;

    @FindBy(css = ".sidebar-menu > [index='3'] li")
    private ElementsCollection leftMenuServiceDropdownItems;

    // ----- RIGHT Section -----
    @FindBy(css = ".logs")
    private SelenideElement log;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    // ===== METHODS =====
    @Step("Assert Browser title")
    public void assertBrowserTitle(URLs title) {
        pageTitle.shouldHave(attribute("text", title.getTitle()));
    }

    // ----- HEADER Methods -----
    @Step("Perform login {0}")
    public void login(Users user) {
        userIcon.click();
        userNameInput.sendKeys(user.getLogin());
        userPassInput.sendKeys(user.getPass());
        loginButton.click();
    }

    @Step("Assert User name")
    public void assertUserName(Users user) {
        userNameText.shouldBe(visible);
        userNameText.shouldHave(text(user.getName().toUpperCase()));
    }

    @Step("Click on 'Service' subcategory in the header and check that dropdown contains options")
    public void assertTopMenuServiceDropdownElements(ServiceDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (ServiceDropdownItems item : items) {
            expectedElements.add(item.toString().toUpperCase());
        }
        headerMenuServiceDropdown.click();
        headerMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    @Step("Open through the header menu Service {0} Page")
    public void headerMenuServiceSelect(ServiceDropdownItems item) {
        headerMenuServiceDropdown.click();
        headerMenuServiceDropdownItems.get(item.ordinal()).click();
    }


    // ----- LEFT MENU Methods -----
    @Step("Check that left section dropdown contains options")
    public void assertLeftSectionServiceDropdown(ServiceDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (ServiceDropdownItems item : items) {
            expectedElements.add(item.toString());
        }
        leftMenuServiceDropdown.click();
        leftMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    @Step("Check that left section is present")
    public void assertLeftSectionIsPresent() {
        leftSection.shouldBe(visible);
    }

    // ----- RIGHT SECTION Methods -----
    @Step("Assert logs values")
    public void assertLog(String... expectedLog) {
        logs.first(expectedLog.length).shouldHave(texts(expectedLog));
    }
}


    // ----- COMMON Methods -----
//    private static void assertElementsContains(ElementsCollection elements, List<String> expectedElements) {
//        // This supplementary method was intended to check if only a part of interface matches expected values
//        // Has not found this type of Condition in Selenide
//        List<String> elementsTexts = elements.texts();
//        elements.shouldHave(sizeGreaterThanOrEqual(expectedElements.size()));
//        assertTrue(elementsTexts.containsAll(expectedElements));
//    }

//    public DifferentElementsPage headerMenuServiceSelectDifferentElements() {
//        headerMenuServiceDropdown.click();
//        headerMenuServiceDropdownDifferentElements.click();
//        return page(DifferentElementsPage.class);
//    }

//    public DatesPage headerMenuServiceSelectDates() {
//        headerMenuServiceDropdown.click();
//        headerMenuServiceDropdownDates.click();
//        return page(DatesPage.class);
//    }
