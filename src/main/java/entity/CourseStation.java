package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CourseStation {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Station station;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Course course;

    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public CourseStation() {
        this(null, null, null, null);
    }

    public CourseStation(Station station, Course course, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.station = station;
        this.course = course;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "StacjaKursu{" +
                "stacja=" + station +
                ", kurs=" + course +
                ", godzina przyjazdu=" + arrivalTime +
                ", godzina odjazdu=" + departureTime +
                '}';
    }
}
