package enums;

public enum Users {
    PITER_CHAILOVSKII("Piter Chailovskii", "epam", "1234");

    private final String name;
    private final String login;
    private final String pass;

    Users(String name, String login, String pass) {
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public static Users userByName(String username) {
        for (Users user : Users.values()) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Name not found: " + username);
    }
}
