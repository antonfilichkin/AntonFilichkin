package hw7.entities;

import enums.Users;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public static User PITER = new User("epam", "1234", "Piter Chailovskii");

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
