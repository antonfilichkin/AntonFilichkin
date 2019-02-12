package hw4.Pages;

import base.Enums.Users;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.SupportDropdownItems;
import hw4.Enums.URLs;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

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
    private SelenideElement HeaderMenuServiceDropdownDifferentElements;

    @FindBy(css = ".m-l8  a[href^='dates']")
    private SelenideElement HeaderMenuServiceDropdownDates;

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
    public void assertBrowserTitle(URLs title) {
        pageTitle.shouldHave(attribute("text", title.getTitle()));
    }

    // ----- HEADER Methods -----
    public void login(Users user) {
        userIcon.click();
        userNameInput.sendKeys(user.getLogin());
        userPassInput.sendKeys(user.getPass());
        loginButton.click();
    }

    public void assertUserName(Users user) {
        userNameText.shouldBe(visible);
        userNameText.shouldHave(text(user.getName().toUpperCase()));
    }

    public void assertTopMenuServiceDropdownElements(SupportDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (SupportDropdownItems item : items) {
            expectedElements.add(item.toString().toUpperCase());
        }
        headerMenuServiceDropdown.click();
        headerMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    public DifferentElementsPage headerMenuServiceSelectDifferentElements() {
        headerMenuServiceDropdown.click();
        HeaderMenuServiceDropdownDifferentElements.click();
        return page(DifferentElementsPage.class);
    }

    public DatesPage headerMenuServiceSelectDates() {
        headerMenuServiceDropdown.click();
        HeaderMenuServiceDropdownDates.click();
        return page(DatesPage.class);
    }

    // ----- LEFT MENU Methods -----
    public void assertLeftSectionIsPresent() {
        leftSection.shouldBe(visible);
    }

    public void assertLeftSectionServiceDropdown(SupportDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (SupportDropdownItems item : items) {
            expectedElements.add(item.toString());
        }
        leftMenuServiceDropdown.click();
        leftMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    // ----- RIGHT SECTION Methods -----
    public void assertLog(String... expectedLog) {
        logs.first(expectedLog.length).shouldHave(texts(expectedLog));
    }

    // ----- COMMON Methods -----
    private static void assertElementsContains(ElementsCollection elements, List<String> expectedElements) {
        // This supplementary method was intended to check if only a part of interface matches expected values
        // Has not found this type of Condition in Selenide
        List<String> elementsTexts = elements.texts();
        elements.shouldHave(sizeGreaterThanOrEqual(expectedElements.size()));
        assertTrue(elementsTexts.containsAll(expectedElements));
    }
}