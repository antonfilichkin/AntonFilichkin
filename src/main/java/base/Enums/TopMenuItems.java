package base.Enums;

public enum TopMenuItems {
    HOME ("HOME"),
    CONTACT_FORM ("CONTACT FORM"),
    SERVICE ("SERVICE"),
    METALS_COLORS ("METALS & COLORS");

    private static final int size = TopMenuItems.values().length;

    private final String item;

    TopMenuItems(String item) {
        this.item = item;
    }

    public static int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return item;
    }
}