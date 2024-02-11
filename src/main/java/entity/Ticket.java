package entity;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private CourseSubspan courseSubspan;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Person owner;

    public Ticket(CourseSubspan courseSubspan, Person owner) {
        this.courseSubspan = courseSubspan;
        this.owner = owner;
    }

    public Ticket() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", courseSubspan=" + courseSubspan +
                ", owner=" + owner +
                '}';
    }
}
