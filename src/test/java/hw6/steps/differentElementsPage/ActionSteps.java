package hw6.steps.differentElementsPage;

import cucumber.api.java.en.When;
import enums.Colors;
import enums.Elements;
import enums.Metals;
import pages.hw6.DifferentElementsPage;

import java.util.List;

public class ActionSteps {
    @When("^I set checkboxes \"([^\"]*)\" to \"(true|false)\"$")
    public void iSetCheckboxes(List<Elements> options, boolean status){
        Elements[] items = options.toArray(new Elements[0]);
        new DifferentElementsPage().setCheckboxes(items, status);
    }

    @When("^I select radio	\"([^\"]*)\"$")
    public void iSelectRadio(Metals metal){
        new DifferentElementsPage().selectRadioButtons(metal);
    }

    @When("^I select in dropdown \"([^\"]*)\"$")
    public void iSelectInDropdown(Colors color){
        new DifferentElementsPage().selectDropdown(color);
    }
}