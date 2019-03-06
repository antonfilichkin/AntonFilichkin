package entities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static enums.Colors.RED;
import static enums.Metals.SELEN;
import static enums.NatureElements.EARTH;
import static enums.NatureElements.WIND;
import static enums.ResultsLog.*;
import static enums.Vegetables.CUCUMBER;
import static enums.Vegetables.TOMATO;

public class Elements {
    public static Elements DEFAULT = new Elements(
            new int[] {3, 8},
            new String[]{WIND.toString(), EARTH.toString()},
            RED.toString(),
            SELEN.toString(),
            new String[]{CUCUMBER.toString(), TOMATO.toString()}
    );

    public int[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public Elements(int[] summary, String[] elements, String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public static Map<String, String> getExpectedResult(Elements elements) {
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put(SUMM.getSelector(), SUMM.getResultStringStartsWith() + (elements.summary[0] + elements.summary[1]));
        expectedResult.put(ELEMENTS.getSelector(), ELEMENTS.getResultStringStartsWith() + arrayToStringWOParentheses(elements.elements));
        expectedResult.put(METAL.getSelector(), METAL.getResultStringStartsWith() + elements.metals);
        expectedResult.put(COLOR.getSelector(), COLOR.getResultStringStartsWith() + elements.color);
        expectedResult.put(VEGETABLES.getSelector(), VEGETABLES.getResultStringStartsWith() + arrayToStringWOParentheses(elements.vegetables));
        return expectedResult;
    }

    private static String arrayToStringWOParentheses(String[] stringsArray) {
        return Arrays.toString(stringsArray).replace("[", "").replace("]", "").trim();
    }
}
