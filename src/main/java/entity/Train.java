package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Train {
    @Id
    private String trainNumber;

    public Train() {
        this.trainNumber = "";
    }

    public Train(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Override
    public String toString() {
        return "Pociąg{" + trainNumber + "}";
    }
}
