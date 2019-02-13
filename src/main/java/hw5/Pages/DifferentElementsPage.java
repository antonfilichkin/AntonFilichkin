package hw5.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.Colors;
import hw4.Enums.Elements;
import hw4.Enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage extends BaseNavigation {
    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkBoxes;

    @FindBy(css = "[type='radio']")
    private ElementsCollection radioButtons;

    @FindBy(css = "select")
    private ElementsCollection dropdowns;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "[value*='Button']")
    private ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightPanel;

    @Step("Check interface on Different elements page")
    public void checkInterface() {
        checkBoxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropdowns.shouldHaveSize(1);
        buttons.shouldHaveSize(2);
    }

    @Step("Assert that there is Right Section")
    public void assertRightSectionIsPresent() {
        rightPanel.shouldBe(visible);
    }

    @Step("Select checkboxes")
    public void selectCheckboxes(Elements... elements) {
        for (Elements element : elements) {
            checkBoxes.get(element.ordinal()).setSelected(true);
        }
    }

    @Step("Unselect checkboxes")
    public void unselectCheckboxes(Elements... elements) {
        for (Elements element : elements) {
            checkBoxes.get(element.ordinal()).setSelected(false);
        }
    }

    @Step("Select radio")
    public void selectRadioButtons(Metals metal) {
        radioButtons.get(metal.ordinal()).setSelected(true);
    }

    @Step("Select Dropdown")
    public void selectDropdown(Colors color) {
        dropdown.selectOptionContainingText(color.toString());
    }
}