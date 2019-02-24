package entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SuperHero {
    int number;
    String type;
    String user;
    String desciption;

    public SuperHero(int number, String user, String desciption) {
        this.number = number;
        this.type = null;
        this.user = user;
        this.desciption = desciption;
    }
}
