package base.Enums;

import static base.Enums.HomePageSelectors.*;

public enum Benefits {
    PRACTISE (ICON_PRACTISE_CSS.toString(), "To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM (ICON_CUSTOM_CSS.toString(), "To be flexible and\ncustomizable"),
    MULTI (ICON_MULTI_CSS.toString(), "To be multiplatform"),
    BASE (ICON_BASE_CSS.toString(), "Already have good base\n(about 20 internal and\nsome external projects),\n" +
            "wish to get more…");

    private static final int size = Benefits.values().length;

    private final String iconSelector;
    private final String text;

    Benefits(String iconSelector, String text) {
        this.iconSelector = iconSelector;
        this.text = text;
    }

    public String getIcon() {
        return iconSelector;
    }

    public String getText() {
        return text;
    }

    public static int getSize() {
        return size;
    }
}