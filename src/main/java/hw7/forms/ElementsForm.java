package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.Elements;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static org.openqa.selenium.By.cssSelector;

public class ElementsForm extends Form<Elements> {
    @Css("#odds-selector > p")
    RadioButtons odds;

    @Css("#even-selector > p")
    RadioButtons evens;

    @Css("#elements-checklist")
    Checklist elements = new HtmlChecklist() {
        By checkbox = cssSelector("input[type=checkbox][id='%s'] + *");
        By label = LABEL_LOCATOR;

        @Override
        public HtmlElement get(String value) {
            return $(fillByTemplate(checkbox, getId(value)), parent).setName("checkboxes");
        }

        private String getId(String name) {
            return label(name).getAttribute("for");
        }

        private HtmlElement label(String value) {
            return $(fillByTemplate(label, value), parent).setName("label");
        }
    };

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    Droplist colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    Droplist vegetables;

    @Css("#calculate-button")
    Button calculate;

    @Css("#submit-button")
    Button submit;

    @Override
    public void fill(Elements entity) {
        odds.select(entity.odds);
        evens.select(entity.evens);
        elements.select(entity.elements);
        colors.select(entity.colors);
        metals.select(entity.metals);
        selectVegetables(entity.vegetables);
    }

    @Override
    public void submit(Elements entity) {
        fill(entity);
        submit.click();
    }

    private void selectVegetables(String... values) {
        clearVegetables();
        for (String value : values) {
            vegetables.select(value);
        }
    }

    private void clearVegetables() {
        String[] selectedOptions = vegetables.getSelected().split(", ");
        for (String option : selectedOptions) {
            vegetables.select(option);
        }
    }
}