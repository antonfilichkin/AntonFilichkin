package enums;

public enum UserTablePageTableValues {
    ROMAN(1, "Roman", "Wolverine"),
    SERGEY_IVAN(2, "Sergey Ivan", "Soider Man"),
    VLADZIMIR(3, "Vladzimir", "Punisher"),
    HELEN_BENNET(4, "Helen Bennett", "Captain America\nsome description"),
    YOSHI_TANNAMURI(5, "Yoshi Tannamuri", "Cyclope\nsome description"),
    GIOVANNI_ROVELLI(6, "Giovanni Rovelli", "Hulk\nsome description");

    private final static String[] USER_TABLE_COLUMNS_HEADERS = {"NUMBER", "NAME", "DESCRIPTION"};

    public static String[] getUserTableColumnsHeaders() {
        return USER_TABLE_COLUMNS_HEADERS;
    }

    private final int number;
    private final String name;
    private final String description;

    UserTablePageTableValues(int number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
