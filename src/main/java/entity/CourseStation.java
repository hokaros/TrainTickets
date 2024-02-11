package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CourseStation {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Course course;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Station station;


    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public CourseStation() {
        this(null, null, null, null);
    }

    public CourseStation(Course course, Station station, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.course = course;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Station getStation() {
        return station;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "StacjaKursu{" +
                "kurs=" + course +
                ", stacja=" + station +
                ", godzina przyjazdu=" + arrivalTime +
                ", godzina odjazdu=" + departureTime +
                '}';
    }
}
