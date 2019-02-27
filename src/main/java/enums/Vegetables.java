package enums;

public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    private final String vegetable;

    Vegetables(String vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String toString() {
        return vegetable;
    }
}
