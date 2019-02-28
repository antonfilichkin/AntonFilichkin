package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;
import hw7.sections.Header;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    static HomePage homePage;
    static MetalsAndColorsPage metalsAndColorsPage;

    @Css(".uui-header")
    static Header header;
}
