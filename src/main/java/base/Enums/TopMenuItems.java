package base.Enums;

public enum TopMenuItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private static final int size = TopMenuItems.values().length;

    private final String item;

    TopMenuItems(String item) {
        this.item = item;
    }

    public static int getSize() {
        return size;
    }

    public static String[] getAll() {
        String[] allItems = new String[size];
        int i = 0;
        for (TopMenuItems items : TopMenuItems.values()) {
            allItems[i++] = items.toString();
        }
        return allItems;
    }

    @Override
    public String toString() {
        return item;
    }
}