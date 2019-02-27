package hw6.steps.differentElementsPage;

import cucumber.api.java.en.When;
import enums.Colors;
import enums.NatureElements;
import enums.Metals;
import pages.hw6.DifferentElementsPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private DifferentElementsPage differentElementsPage = page(DifferentElementsPage.class);

    @When("^I set checkboxes \"([^\"]*)\" to \"(true|false)\"$")
    public void iSetCheckboxes(List<NatureElements> options, boolean status){
        NatureElements[] items = options.toArray(new NatureElements[0]);
        differentElementsPage.setCheckboxes(items, status);
    }

    @When("^I select radio	\"([^\"]*)\"$")
    public void iSelectRadio(Metals metal){
        differentElementsPage.selectRadioButtons(metal);
    }

    @When("^I select in dropdown \"([^\"]*)\"$")
    public void iSelectInDropdown(Colors color){
        differentElementsPage.selectDropdown(color);
    }
}