package hw7.forms;

import com.epam.jdi.light.common.FormFilters;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import com.epam.jdi.tools.map.MapArray;
import hw7.entities.Elements;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.List;

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

    //TODO Realise Method
    @Override
    public void check(Elements entity) {
        throw new UnsupportedOperationException();
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

    // ----- Not sure if it is going to work -----

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAction(Field field, Object element, Object parent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FormFilters getFilter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFilterAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFilter(FormFilters filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void fill(MapArray<String, String> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Form<Elements> setPageObject(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Field> allFields() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Field> allFields(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Form<Elements> onlyMandatory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Form<Elements> onlyOptional() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<String> verify(MapArray<String, String> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> verify(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void check(MapArray<String, String> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void submit(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void submit(String text, String buttonName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void submit(Elements entity, String buttonName) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void submit(MapArray<String, String> objStrings, String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void submit(MapArray<String, String> objStrings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loginAs(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void send(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void publish(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void back(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void select(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void next(Elements entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void search(Elements entity) {
        throw new UnsupportedOperationException();
    }
}