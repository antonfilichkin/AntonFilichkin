package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.forms.ElementsForm;
import hw7.sections.LogSidebar;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @Css(".form")
    public static ElementsForm elementsForm;

    @Css("[name=log-sidebar]")
    public static LogSidebar logSidebar;
}