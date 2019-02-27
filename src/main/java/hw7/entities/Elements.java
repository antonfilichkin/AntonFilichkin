package hw7.entities;

import enums.Colors;
import enums.Metals;
import enums.NatureElements;
import enums.Vegetables;

import java.util.Arrays;

public class Elements {
    public String odds;
    public String evens;
    public String[] elements;
    public String colors;
    public String metals;
    public String[] vegetables;

    public Elements(String odds, String evens, String[] elements, String colors, String metals, String[] vegetables) {
        this.odds = odds;
        this.evens = evens;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public Elements(int odds, int evens, NatureElements[] elements, Colors color, Metals metall, Vegetables[] vegetables) {
        this.odds = String.valueOf(odds);
        this.evens = String.valueOf(evens);
        this.colors = color.toString();
        this.metals = metall.toString();
        this.elements = Arrays.stream(elements).map(Enum::toString).toArray(String[]::new);
        this.vegetables = Arrays.stream(vegetables).map(Enum::toString).toArray(String[]::new);
    }

    //TODO Return HashMap
//            0 = {HashMap$Node@5098} "summ-res" -> "Summary: 11"
//            1 = {HashMap$Node@5099} "elem-res" -> "Elements: Earth, Wind"
//            2 = {HashMap$Node@5100} "met-res" -> "Metal: Selen"
//            3 = {HashMap$Node@5101} "col-res" -> "Color: Red"
//            4 = {HashMap$Node@5102} "sal-res" -> "Vegetables: Cucumber, Tomato"
}
