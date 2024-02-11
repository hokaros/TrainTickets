package view.passenger;

import entity.Course;
import entity.CourseStation;
import entity.CourseSubspan;
import entity.Station;
import repository.RepositoryCollection;
import view.EntitySelectionView;

import java.util.ArrayList;
import java.util.List;

public class SelectMatchingCourseView extends EntitySelectionView<CourseSubspan> {

    private final RepositoryCollection repositories;

    private final Station startStation;
    private final Station endStation;

    public SelectMatchingCourseView(Station startStation, Station endStation, RepositoryCollection repositories) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.repositories = repositories;
    }

    @Override
    protected List<CourseSubspan> getAll() {
        // Wybierz te kursy, które posiadają zadaną stację początkową i końcową
        List<Course> courses = repositories.getCourseRepository().getAll();

        List<CourseSubspan> courseSubspans = new ArrayList<>();
        for(Course course : courses) {
            CourseStation courseStartStation = null;
            CourseStation courseEndStation = null;

            for(CourseStation courseStation : course.getStations()) {
                if(courseStation.getStation().equals(startStation)) {
                    courseStartStation = courseStation;
                }
                if(courseStation.getStation().equals(endStation)) {
                    courseEndStation = courseStation;
                }
            }

            if(courseStartStation == null || courseEndStation == null)
                continue;

            if(courseStartStation.getDepartureTime().isAfter(courseEndStation.getDepartureTime()))
                continue;

            CourseSubspan courseSubspan = new CourseSubspan(courseStartStation, courseEndStation);
            courseSubspans.add(courseSubspan);
        }

        return courseSubspans;
    }

    @Override
    protected void printTitle() {
        System.out.println("Wybierz kurs:");
    }
}
