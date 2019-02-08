package hw4.Enums;

public enum TopMenuItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private final String item;

    TopMenuItems(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}