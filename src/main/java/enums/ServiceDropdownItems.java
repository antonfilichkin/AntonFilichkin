package enums;

public enum ServiceDropdownItems {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private final String item;

    ServiceDropdownItems(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
