package hw7.entities;

import enums.Users;

public class User {
    String login;
    String password;
    String fullName;

    public User(Users user) {
        this.login = user.getLogin();
        this.password = user.getPass();
        this.fullName = user.getName();
    }

    public String getFullName() {
        return fullName;
    }
}
