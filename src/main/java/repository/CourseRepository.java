package repository;

import entity.Course;
import entity.Station;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CourseRepository extends JpaRepository<Course, Long>{

    public CourseRepository(EntityManagerFactory emf) {
        super(emf, Course.class);
    }

    public List<Course> getCoursesWithStations(Station startStation, Station endStation) {

        EntityManager em = getEmf().createEntityManager();

        List<Course> courses = em.createQuery("SELECT course FROM Course course " +
                "JOIN CourseStation cs ON cs.course = course.id" +
                "JOIN Station station ON cs.stationName = station.name", clazz).getResultList();

        em.close();
        return courses;
    }
}
