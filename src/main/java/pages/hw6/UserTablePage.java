package pages.hw6;

import com.codeborne.selenide.ElementsCollection;
import enums.Elements;
import enums.UserTablePageElements;
import enums.UserTablePageTableValues;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class UserTablePage extends BaseNavigation {
    private final static int USER_TABLE_SIZE = 6;

    @FindBy(css = "[id='user-table'] td:first-child")
    private ElementsCollection userNumbers;

    @FindBy(css = "[id='user-table'] select")
    private ElementsCollection typeDropdowns;

    @FindBy(css = "[id='user-table'] a")
    private ElementsCollection userNames;

    @FindBy(css = "[id='user-table'] img")
    private ElementsCollection descriptionImages;

    @FindBy(css = ".user-descr span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = ".user-descr [type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[id='user-table'] th")
    private ElementsCollection tableHeader;

    @FindBy(css = "[id='user-table'] tr")
    private ElementsCollection tableRows;

    public void checkInterface(UserTablePageElements element, int quantity) {
        switch (element) {
            case NUMBERS:
                assertElementsAreDisplayed(userNumbers, quantity);
                break;
            case DROPDOWNS:
                assertElementsAreDisplayed(typeDropdowns, quantity);
                break;
            case USER_NAMES:
                assertElementsAreDisplayed(userNames, quantity);
                break;
            case DESCRIPTION_IMAGES:
                assertElementsAreDisplayed(descriptionImages, quantity);
                break;
            case DESCRIPTION_TEXTS:
                assertElementsAreDisplayed(descriptionTexts, quantity);
                break;
            case CHECKBOXES:
                assertElementsAreDisplayed(checkboxes, quantity);
                break;
        }
    }

    public void assertTableContents(List<List<String>> rows) {
        tableRows.shouldHave(size(rows.size()));
        String rowSelector = "th";
        for (int i = 0; i < rows.size(); i++) {
            tableRows.get(i).$$(rowSelector).get(0).shouldHave(text(rows.get(i).get(0)));
            tableRows.get(i).$$(rowSelector).get(2).shouldHave(text(rows.get(i).get(1)));
            tableRows.get(i).$$(rowSelector).get(3).shouldHave(text(rows.get(i).get(2)));
            rowSelector = "td";
        }
    }

    public void clickCheckbox(UserTablePageTableValues element) {
        checkboxes.get(element.ordinal()).click();
    }

    public void clickDropdown(UserTablePageTableValues element) {
        typeDropdowns.get(element.ordinal()).click();
    }

    public void dropdownContains(UserTablePageTableValues elements, List<String> texts) {
        typeDropdowns.get(elements.ordinal()).$$("option").shouldHave(texts(texts));
    }

    public void checkAllInterface() {
        assertElementsAreDisplayed(userNumbers, USER_TABLE_SIZE);
        assertElementsAreDisplayed(typeDropdowns, USER_TABLE_SIZE);
        assertElementsAreDisplayed(userNames, USER_TABLE_SIZE);
        assertElementsAreDisplayed(userNames, USER_TABLE_SIZE);
        assertElementsAreDisplayed(descriptionImages, USER_TABLE_SIZE);
        assertElementsAreDisplayed(descriptionTexts, USER_TABLE_SIZE);
        assertElementsAreDisplayed(checkboxes, USER_TABLE_SIZE);
    }

    private void assertElementsAreDisplayed(ElementsCollection elements, int size) {
        elements.shouldHaveSize(size).filter(visible).shouldHaveSize(size);
    }
}

//        #    Then 1 log row has "Vip: condition changed to true" text in log section
//        #
//        #    When I click on dropdown in column Type for user Roman
//        #    Then droplist contains values
//        #      | Admin                          |
//        #      | User                           |
//        #      | Manager                        |
//
//
//
