package view.planner;

import entity.Course;
import entity.Station;
import entity.Train;
import repository.RepositoryCollection;

import java.util.Scanner;

public class AddCourseView {

    private Scanner scanner = new Scanner(System.in);

    private RepositoryCollection repositories;

    public AddCourseView(RepositoryCollection repositories) {
        this.repositories = repositories;
    }

    public Course run() {
        System.out.println("\n\n<<Nowy kurs>>");

        Train train = promptTrain();

        Course course = new Course(train);
        repositories.getCourseRepository().add(course);

        System.out.println("Dodano kurs");
        return course;
    }

    private Train promptTrain() {
        SelectTrainView selectTrainView = new SelectTrainView(repositories.getTrainRepository());
        return selectTrainView.run();
    }
}
