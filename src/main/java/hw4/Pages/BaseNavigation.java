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

    // ----- FOOTER -----
    @FindBy(css = ".footer-bg")
    private SelenideElement footer;

    // ----- LEFT MENU -----
    @FindBy(css = ".uui-side-bar")
    private SelenideElement leftSection;

    @FindBy(css = ".sidebar-menu > [index='3']")
    private SelenideElement leftMenuServiceDropdown;

    // ----- RIGHT Section -----
    @FindBy(css = ".logs")
    private SelenideElement log;

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
        headerMenuServiceDropdown.click();
        List<String> expectedElements = new ArrayList<>();
        for (SupportDropdownItems item : items) {
            expectedElements.add(item.toString().toUpperCase());
        }
        assertElementsContains(headerMenuServiceDropdown.$$("li"), expectedElements);
    }

    @SuppressWarnings("unchecked")
    public <Page extends BaseNavigation> Page headerMenuServiceSelect(SupportDropdownItems item) {
        headerMenuServiceDropdown.click();
        headerMenuServiceDropdown.$$("li").get(item.ordinal()).click();
        switch (item) {
            case DIFFERENT_ELEMENTS:
                return (Page) page(DifferentElementsPage.class);
            case DATES:
                return (Page) page(DatesPage.class);
            default:
                return (Page) page(HomePage.class);
        }
    }

    // ----- LEFT MENU Methods -----
    public void assertLeftSectionIsPresent() {
        leftSection.shouldBe(visible);
    }

    public void assertLeftSectionServiceDropdown(SupportDropdownItems... items) {
        leftMenuServiceDropdown.click();
        List<String> expectedElements = new ArrayList<>();
        for (SupportDropdownItems item : items) {
            expectedElements.add(item.toString());
        }
        assertElementsContains(leftMenuServiceDropdown.$$("li"), expectedElements);
    }

    // ----- RIGHT SECTION Methods -----
    public void assertLog(String... expectedLog) {
        ElementsCollection logs = log.$$("li");
        logs.shouldBe(sizeGreaterThanOrEqual(expectedLog.length));
        for (int i = 0; i < expectedLog.length; ++i) {
            logs.get(i).shouldHave(text(expectedLog[i]));
        }
    }

    // ----- COMMON Methods -----
    private static void assertElementsContains(ElementsCollection elements, List<String> expectedElements) {
        List<String> elementsTexts = elements.texts();
        elements.shouldHave(sizeGreaterThanOrEqual(expectedElements.size()));
        assertTrue(elementsTexts.containsAll(expectedElements));
    }
}