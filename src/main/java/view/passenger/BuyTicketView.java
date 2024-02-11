package view.passenger;

import entity.CourseSubspan;
import entity.Person;
import entity.Station;
import entity.Ticket;
import repository.RepositoryCollection;
import view.SelectStationView;

public class BuyTicketView {

    private final Person user;
    private final RepositoryCollection repositories;

    public BuyTicketView(Person user, RepositoryCollection repositories) {
        this.user = user;
        this.repositories = repositories;
    }

    public Ticket run() {
        Station startStation = promptStartStation();
        Station endStation = promptEndStation();

        CourseSubspan courseSubspan = promptCourse(startStation, endStation);

        Ticket ticket = new Ticket(courseSubspan, user);
        repositories.getTicketRepository().add(ticket);

        System.out.println("* Zakupiono bilet *");
        return ticket;
    }

    private Station promptStartStation() {
        System.out.println("Stacja początkowa:");
        SelectStationView selectStationView = new SelectStationView(repositories.getStationRepository());
        return selectStationView.run();
    }

    private Station promptEndStation() {
        System.out.println("Stacja końcowa:");
        SelectStationView selectStationView = new SelectStationView(repositories.getStationRepository());
        return selectStationView.run();
    }

    private CourseSubspan promptCourse(Station startStation, Station endStation) {
        SelectMatchingCourseView selectMatchingCourseView = new SelectMatchingCourseView(startStation, endStation, repositories);
        return selectMatchingCourseView.run();
    }
}
