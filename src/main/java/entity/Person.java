package entity;
import javax.persistence.*;

@Entity
@Table(name = "People")
public class Person {
    @Id
    private String email;

    private String firstName;
    private String surname;

    public Person() {
        this("", "", "");
    }

    public Person(String email, String firstName, String surname) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" + firstName + " " + surname + ", e-mail: " + email + "}";
    }
}
