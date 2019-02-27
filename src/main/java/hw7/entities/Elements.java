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

    public Elements(int odds, int evens, NatureElements[] elements, Colors color, Metals metall, Vegetables[] vegetables) {
        this.odds = String.valueOf(odds);
        this.evens = String.valueOf(evens);
        this.colors = color.toString();
        this.metals = metall.toString();
        this.elements = Arrays.stream(elements).map(Enum::toString).toArray(String[]::new);
        this.vegetables = Arrays.stream(vegetables).map(Enum::toString).toArray(String[]::new);
    }
}
