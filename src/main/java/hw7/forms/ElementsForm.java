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
    private RadioButtons odds;

    @Css("#even-selector > p")
    private RadioButtons evens;

    @Css("#elements-checklist")
    private Checklist elements = new HtmlChecklist() {
        By checkbox = cssSelector("input[type=checkbox][id='%s'] + *");
        By label = By.xpath(".//label[text()='%s']");

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
    private Droplist colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetables;

    @Css("#calculate-button")
    private Button calculate;

    @Css("#submit-button")
    private Button submit;

    @Override
    public void fill(Elements entity) {
        odds.select(entity.odds);
        evens.select(entity.evens);
        elements.select(entity.elements);
        colors.select(entity.color);
        metals.select(entity.metal);
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

    // ----- Not sure if it is going to work? => Make sure it won't work! -----

    @Override
    public void check(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public String getAction(Field field, Object element, Object parent) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public FormFilters getFilter() {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void setFilterAll() {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void setFilter(FormFilters filter) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    protected void fill(MapArray<String, String> map) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public Form<Elements> setPageObject(Object obj) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public List<Field> allFields() {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public List<Field> allFields(Object obj) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public Form<Elements> onlyMandatory() {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public Form<Elements> onlyOptional() {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    protected List<String> verify(MapArray<String, String> map) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public List<String> verify(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    protected void check(MapArray<String, String> map) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void submit(String text) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void submit(String text, String buttonName) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void submit(Elements entity, String buttonName) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    protected void submit(MapArray<String, String> objStrings, String name) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    protected void submit(MapArray<String, String> objStrings) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void login(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void loginAs(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void send(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void add(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void publish(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void save(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void update(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void cancel(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void close(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void back(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void select(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void next(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }

    @Override
    public void search(Elements entity) {
        throw new UnsupportedOperationException("I am going to build my own Form, with methods and buttons... Some day.");
    }
}