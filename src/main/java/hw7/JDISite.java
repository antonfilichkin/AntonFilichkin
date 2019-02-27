package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.sections.Header;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    public static HomePage homePage;

    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css(".uui-header")
    public static Header header;
}
