package pages.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Colors;
import enums.Elements;
import enums.Metals;
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

    public void checkInterface() {
        checkBoxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        dropdowns.shouldHaveSize(1);
        buttons.shouldHaveSize(2);
    }

    public void assertRightSectionIsPresent() {
        rightPanel.shouldBe(visible);
    }

    public void selectCheckboxes(Elements... elements) {
        for (Elements element : elements) {
            checkBoxes.get(element.ordinal()).setSelected(true);
        }
    }

    public void unselectCheckboxes(Elements... elements) {
        for (Elements element : elements) {
            checkBoxes.get(element.ordinal()).setSelected(false);
        }
    }

    public void selectRadioButtons(Metals metal) {
        radioButtons.get(metal.ordinal()).setSelected(true);
    }

    public void selectDropdown(Colors color) {
        dropdown.selectOptionContainingText(color.toString());
    }
}