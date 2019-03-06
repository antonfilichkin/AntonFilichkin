package entities;

import enums.Colors;
import enums.Metals;
import enums.NatureElements;
import enums.Vegetables;

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

public class ElementsJSON {

    public static ElementsJSON DEFAULT = new ElementsJSON(
            3, 8,
            new NatureElements[]{WIND, EARTH},
            RED, SELEN,
            new Vegetables[]{CUCUMBER, TOMATO}
    );

    public int odds;
    public int evens;
    public String[] elements;
    public String color;
    public String metal;
    public String[] vegetables;

    private Map<String, String> expectedResult;

    public ElementsJSON(int odds, int evens, NatureElements[] elements, Colors color, Metals metal, Vegetables[] vegetables) {
        this.odds = odds;
        this.evens = evens;
        this.elements = Arrays.stream(elements).sorted().map(Enum::toString).toArray(String[]::new);
        this.color = color.toString();
        this.metal = metal.toString();
        this.vegetables = Arrays.stream(vegetables).sorted().map(Enum::toString).toArray(String[]::new);
    }

    public ElementsJSON(Integer[] numbers, String[] elements, String color, String metal, String[] vegetables) {
        this.odds = numbers[0];
        this.evens = numbers[1];
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public Map<String, String> getExpectedResult() {
        if (expectedResult == null) {
            expectedResult = new HashMap<>();
            generateExpectedResult();
        }
        return expectedResult;
    }

    private void generateExpectedResult() {
        expectedResult.put(SUMM.getSelector(), SUMM.getResultStringStartsWith() + (odds + evens));
        expectedResult.put(ELEMENTS.getSelector(), ELEMENTS.getResultStringStartsWith() + arrayToStringWOParentheses(elements));
        expectedResult.put(METAL.getSelector(), METAL.getResultStringStartsWith() + metal);
        expectedResult.put(COLOR.getSelector(), COLOR.getResultStringStartsWith() + color);
        expectedResult.put(VEGETABLES.getSelector(), VEGETABLES.getResultStringStartsWith() + arrayToStringWOParentheses(vegetables));
    }

    private String arrayToStringWOParentheses(String... stringsArray) {
        return Arrays.toString(stringsArray).replace("[", "").replace("]", "").trim();
    }
}
