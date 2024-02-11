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
    public boolean equals(Object obj) {
        if(obj instanceof Station)
            return this.name.equals(((Station) obj).name);

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Stacja{" + name + "}";
    }
}
