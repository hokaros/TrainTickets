package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Train train;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<CourseStation> stations;

    public Course(Train train) {
        this.train = train;
    }

    public Course() {
        this.train = null;
    }

    public List<CourseStation> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Kurs{Pociąg: " + train + ", id: " + id + "}";
    }
}
