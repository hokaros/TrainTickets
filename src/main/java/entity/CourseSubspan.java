package entity;

import javax.persistence.*;

@Entity
public class CourseSubspan {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private CourseStation startStation;

    @ManyToOne(cascade = CascadeType.DETACH)
    private CourseStation endStation;

    public CourseSubspan(CourseStation startStation, CourseStation endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public CourseSubspan() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "OdcinekKursu{" +
                "stacja początkowa: " + startStation +
                ", stacja końcowa: " + endStation +
                '}';
    }
}
