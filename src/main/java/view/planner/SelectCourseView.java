package view.planner;

import entity.Course;
import repository.CourseRepository;
import view.EntitySelectionView;

import java.util.List;

public class SelectCourseView extends EntitySelectionView<Course> {
    private CourseRepository courseRepository;

    public SelectCourseView(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    protected List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    protected void printTitle() {
        System.out.println("Wybierz kurs:");
    }
}
