package pages.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceDropdownItems;
import enums.TopMenuItems;
import enums.URLs;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

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

    @FindBy(css = ".m-l8 > li")
    private ElementsCollection headerMenuItems;

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

    @FindBy(css = ".sidebar-menu > li")
    private ElementsCollection leftMenuItems;

    @FindBy(css = ".sidebar-menu > [index='3']")
    private SelenideElement leftMenuServiceDropdown;

    @FindBy(css = ".sidebar-menu > [index='3'] li")
    private ElementsCollection leftMenuServiceDropdownItems;

    // ----- RIGHT Section -----
    @FindBy(css = ".logs")
    private SelenideElement log;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    public BaseNavigation() {
        page(this);
    }

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

    public void headerMenuSelect(TopMenuItems item){
        headerMenuItems.get(item.ordinal()).click();
    }

    public void assertTopMenuServiceDropdownElements(ServiceDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (ServiceDropdownItems item : items) {
            expectedElements.add(item.toString().toUpperCase());
        }
        headerMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    public void headerMenuServiceSelect(ServiceDropdownItems item) {
        headerMenuServiceDropdownItems.get(item.ordinal()).click();
    }

    // ----- LEFT MENU Methods -----
    public void leftMenuSelect(TopMenuItems item){
        leftMenuItems.get(item.ordinal()).click();
    }

    public void assertLeftSectionServiceDropdown(ServiceDropdownItems... items) {
        List<String> expectedElements = new ArrayList<>();
        for (ServiceDropdownItems item : items) {
            expectedElements.add(item.toString());
        }
        leftMenuServiceDropdownItems.shouldHave(texts(expectedElements));
    }

    public void assertLeftSectionIsPresent() {
        leftSection.shouldBe(visible);
    }

    // ----- RIGHT SECTION Methods -----
    public void assertLog(String... expectedLog) {
        logs.first(expectedLog.length).shouldHave(texts(expectedLog));
    }
}
