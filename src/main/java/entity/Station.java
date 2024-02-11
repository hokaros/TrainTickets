package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {
    @Id
    private String name;

    public Station() {
        this.name = "";
    }

    public Station(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stacja{" + name + "}";
    }
}
