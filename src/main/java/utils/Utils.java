package utils;

import org.openqa.selenium.WebElement;

public class Utils {
    public static int calculateThumbXOffset(WebElement range2Slider, WebElement thumb, int desiredValue) {
        int[] sliderSize = getElementEndPointsX(range2Slider);
        int sliderStart = sliderSize[0];
        int sliderEnd = sliderSize[1];
        double sliderResolution = (sliderEnd - sliderStart) / 100d;
        int thumbOffset = thumb.getSize().getWidth() / 2;
        int desiredThumbPosition = sliderStart - thumbOffset + (int) Math.ceil(desiredValue * sliderResolution);
        int currentThumbPosition = thumb.getLocation().getX();
        return desiredThumbPosition - currentThumbPosition;
    }

    private static int[] getElementEndPointsX(WebElement element) {
        int start = element.getLocation().getX();
        int end = start + element.getSize().getWidth();
        return new int[]{start, end};
    }
}