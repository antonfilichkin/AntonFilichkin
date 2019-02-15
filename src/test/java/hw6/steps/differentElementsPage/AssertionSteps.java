package hw6.steps.differentElementsPage;

import cucumber.api.java.en.Then;
import enums.Colors;
import enums.Elements;
import enums.Metals;
import enums.URLs;
import pages.hw6.DifferentElementsPage;

import java.util.List;

public class AssertionSteps {
    @Then("^Page \"([^\"]*)\" is opened$")
    public void pagePageIsOpened(URLs url){
        new DifferentElementsPage().assertBrowserTitle(url);
    }

    @Then("^Different elements page contains all needed elements$")
    public void differentElementsPageContainsAllNeededElements() {
        new DifferentElementsPage().checkInterface();
    }

    @Then("^Right section is displayed$")
    public void rightSectionIsDisplayed() {
        new DifferentElementsPage().assertRightSectionIsPresent();
    }

    @Then("^Left section is displayed$")
    public void thenLeftSectionIsDisplayed() {
        new DifferentElementsPage().assertLeftSectionIsPresent();
    }

    @Then("^Checkboxes \"([^\"]*)\" are .*checked \\(\"([^\"]*)\"\\)$")
    public void elementsAreChecked(List<Elements> options, boolean status){
        Elements[] items = options.toArray(new Elements[0]);
        new DifferentElementsPage().assertCheckboxesStatus(items, status);
    }

    @Then("^There is an individual log for elements:$")
    public void thereIsAnIndividualLogRowAndValueForEachSelectedCheckbox(List<String> logs) {
        String[] logsArray = logs.toArray(new String[0]);
        new DifferentElementsPage().assertLog(logsArray);
    }

    @Then("^Metal \"([^\"]*)\" is checked \\(\"([^\"]*)\"\\)$")
    public void elementIsChecked(Metals metal, boolean status) {
        new DifferentElementsPage().assertRadioButton(metal, status);
    }

    @Then("^Color \"([^\"]*)\" is selected$")
    public void elementIsSelected(Colors color) {
        new DifferentElementsPage().selectDropdown(color);
    }
}