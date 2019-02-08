package hw4.Enums;

public enum SupportDropdownItems {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private final String item;

    SupportDropdownItems(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
