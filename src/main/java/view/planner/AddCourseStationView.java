package view.planner;

import entity.Course;
import entity.CourseStation;
import entity.Station;
import repository.RepositoryCollection;
import view.SelectStationView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddCourseStationView {

    private RepositoryCollection repositories;

    public AddCourseStationView(RepositoryCollection repositories) {
        this.repositories = repositories;
    }

    public CourseStation run() {
        System.out.println("\n\n<<Nowa stacja kursu>>");

        Course course = promptCourse();
        if(course == null) {
            System.out.println("* Anulowano *");
            return null;
        }

        Station station = promptStation();
        if(station == null) {
            System.out.println("* Anulowano *");
            return null;
        }

        LocalDateTime arrivalTime = promptArrivalTime();
        LocalDateTime departureTime = promptDepartureTime();

        CourseStation courseStation = new CourseStation(course, station, arrivalTime, departureTime);
        repositories.getCourseStationRepository().add(courseStation);

        System.out.println("* Dodano stację kursu *");
        return courseStation;
    }

    private Course promptCourse() {
        SelectCourseView selectCourseView = new SelectCourseView(repositories.getCourseRepository());
        return selectCourseView.run();
    }

    private Station promptStation() {
        SelectStationView selectStationView = new SelectStationView(repositories.getStationRepository());
        return selectStationView.run();
    }

    private LocalDateTime promptArrivalTime() {
        System.out.println("Czas przyjazdu:");
        return promptTime();
    }

    private LocalDateTime promptDepartureTime() {
        System.out.println("Czas odjazdu:");
        return promptTime();
    }

    private LocalDateTime promptTime() {
        Scanner scanner = new Scanner(System.in);
        return LocalDateTime.parse(scanner.nextLine());
    }
}
