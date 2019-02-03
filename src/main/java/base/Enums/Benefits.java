package base.Enums;

import static base.Enums.HomePageSelectors.*;

public enum Benefits {
    PRACTISE(ICON_PRACTISE_CSS, "To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM(ICON_CUSTOM_CSS, "To be flexible and\ncustomizable"),
    MULTI(ICON_MULTI_CSS, "To be multiplatform"),
    BASE(ICON_BASE_CSS, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private static final int size = Benefits.values().length;

    private final Enum<HomePageSelectors> iconSelector;
    private final String text;

    Benefits(Enum<HomePageSelectors> iconSelector, String text) {
        this.iconSelector = iconSelector;
        this.text = text;
    }

    public static int getSize() {
        return size;
    }

    public static String[] getAllIcons() {
        String[] allItems = new String[size];
        int i = 0;
        for (Benefits benefits : Benefits.values()) {
            allItems[i++] = benefits.iconSelector.toString();
        }
        return allItems;
    }

    public static String[] getAllTexts() {
        String[] allItems = new String[size];
        int i = 0;
        for (Benefits benefits : Benefits.values()) {
            allItems[i++] = benefits.text;
        }
        return allItems;
    }

    public String getIcon() {
        return iconSelector.toString();
    }

    public String getText() {
        return text;
    }
}