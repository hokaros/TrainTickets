package repository;

import entity.CourseSubspan;

import javax.persistence.EntityManagerFactory;

public class CourseSubspanRepository extends JpaRepository<CourseSubspan, Long> {

    public CourseSubspanRepository(EntityManagerFactory emf) {
        super(emf, CourseSubspan.class);
    }
}
