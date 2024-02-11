package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kurs {
    @Id
    @GeneratedValue
    private long id;
    private String numerPociagu;

    public Kurs(String numerPociagu) {
        this.numerPociagu = numerPociagu;
    }

    @Override
    public String toString() {
        return "Kurs{Pociąg: " + numerPociagu + ", id: " + id + "}";
    }
}
