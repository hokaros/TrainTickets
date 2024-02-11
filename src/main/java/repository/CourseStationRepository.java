package repository;

import entity.CourseStation;

import javax.persistence.EntityManagerFactory;

public class CourseStationRepository extends JpaRepository<CourseStation, Long> {

    public CourseStationRepository(EntityManagerFactory emf) {
        super(emf, CourseStation.class);
    }
}
