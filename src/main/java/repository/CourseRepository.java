package repository;

import entity.Course;
import javax.persistence.EntityManagerFactory;

public class CourseRepository extends JpaRepository<Course, Long>{

    public CourseRepository(EntityManagerFactory emf) {
        super(emf, Course.class);
    }
}
