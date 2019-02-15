package pages.hw6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Benefits;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

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

    public void checkInterface() {
        benefitIcons.shouldHaveSize(4).filter(visible).shouldHaveSize(4);
        benefitTexts.shouldHaveSize(4).filter(visible).shouldHaveSize(4);
        checkTexts(Benefits.values());
        mainTitle.shouldBe(visible);
        mainText.shouldBe(visible);
    }

    private void checkTexts(Benefits... benefits){
        List<String> expectedTexts = new ArrayList<>();
        for (Benefits benefit : benefits){
            expectedTexts.add(benefit.getText());
        }
        benefitTexts.shouldHave(CollectionCondition.texts(expectedTexts));
    }
}