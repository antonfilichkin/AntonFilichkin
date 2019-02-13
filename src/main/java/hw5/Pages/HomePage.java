package hw5.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseNavigation {
    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(css = ".benefit-icon + .benefit-txt")
    private ElementsCollection benefitTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainText;

    @FindBy(css = "[id='iframe']")
    private SelenideElement iframe;

    @FindBy(css = "img[id = 'epam_logo']")
    private SelenideElement epamLogo;
}