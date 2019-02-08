package hw4.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.Enums.Range2SliderThumbs;
import org.openqa.selenium.support.FindBy;

import static hw4.Utils.Utils.calculateThumbXOffset;

public class DatesPage extends BaseNavigation {
    @FindBy(css = ".uui-slider")
    private SelenideElement range2Slider;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection range2SliderThumbs;

    public void setRange2Handle(Range2SliderThumbs thumb, int desiredValue) {
        int xOffset = calculateThumbXOffset(range2Slider, range2SliderThumbs.get(thumb.ordinal()), desiredValue);
        Selenide.actions().dragAndDropBy(range2SliderThumbs.get(thumb.ordinal()), xOffset, 0).perform();
    }
}

//        Actions moveSlider = new Actions(getWebDriver());
//        moveSlider.dragAndDropBy(range2SliderThumbs.get(thumb.ordinal()), xOffset, 0).perform();
//        moveSlider.clickAndHold(range2SliderThumbs.get(thumb.ordinal())).moveByOffset(-10, 0)
//                .moveByOffset(xOffset + 10, 0).release().perform();
//        moveSlider.clickAndHold(range2SliderThumbs.get(thumb.ordinal())).moveByOffset(xOffset, 0).release().perform();
//        moveSlider.clickAndHold(range2SliderThumbs.get(thumb.ordinal())).moveByOffset(xOffset, 0).release().build();
//        moveSlider.perform();