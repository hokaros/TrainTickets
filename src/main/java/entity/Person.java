package entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "People")
public class Person {
    @Id
    private String email;

    private String firstName;
    private String surname;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;

    public Person(String email, String firstName, String surname) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Person() {
        this("", "", "");
    }

    @Override
    public String toString() {
        return "Person{" + firstName + " " + surname + ", e-mail: " + email + "}";
    }
}
