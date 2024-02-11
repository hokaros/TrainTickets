package repository;

import javax.persistence.EntityManagerFactory;

public class RepositoryCollection {

    private CourseRepository courseRepository;
    private CourseStationRepository courseStationRepository;
    private PersonRepository personRepository;
    private StationRepository stationRepository;
    private TrainRepository trainRepository;

    public RepositoryCollection(EntityManagerFactory emf) {
        this.courseRepository = new CourseRepository(emf);
        this.courseStationRepository = new CourseStationRepository(emf);
        this.personRepository = new PersonRepository(emf);
        this.stationRepository = new StationRepository(emf);
        this.trainRepository = new TrainRepository(emf);
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public CourseStationRepository getCourseStationRepository() {
        return courseStationRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public TrainRepository getTrainRepository() {
        return trainRepository;
    }
}
