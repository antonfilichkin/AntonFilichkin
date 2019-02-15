package pages.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Colors;
import enums.Elements;
import enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage extends BaseNavigation {
    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

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
        checkboxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropdowns.shouldHaveSize(1);
        buttons.shouldHaveSize(2);
    }

    @Step("Assert that there is Right Section")
    public void assertRightSectionIsPresent() {
        rightPanel.shouldBe(visible);
    }

    @Step("Set checkboxes")
    public void setCheckboxes(Elements[] elements, boolean status) {
        for (Elements element : elements) {
            checkboxes.get(element.ordinal()).setSelected(status);
        }
    }

    public void assertCheckboxesStatus(Elements[] elements, boolean status) {
        for (Elements element : elements) {
            if (status) {
                checkboxes.get(element.ordinal()).shouldBe(selected);
            } else {
                checkboxes.get(element.ordinal()).shouldBe(not(selected));
            }
        }
    }

    @Step("Select radio")
    public void selectRadioButtons(Metals metal) {
        radioButtons.get(metal.ordinal()).setSelected(true);
    }

    public void assertRadioButton(Metals metal, boolean status) {
        if (status) {
            radioButtons.get(metal.ordinal()).shouldBe(selected);
        } else {
            radioButtons.get(metal.ordinal()).shouldBe(not(selected));
        }
    }

    @Step("Select Dropdown")
    public void selectDropdown(Colors color) {
        dropdown.selectOptionContainingText(color.toString());
    }

    public void assertDropdown(Colors color) {
        dropdown.shouldBe(text(color.toString()));
    }
}