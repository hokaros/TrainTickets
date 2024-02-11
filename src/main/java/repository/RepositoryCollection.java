package repository;

import javax.persistence.EntityManagerFactory;

public class RepositoryCollection {

    private CourseRepository courseRepository;
    private CourseStationRepository courseStationRepository;
    private CourseSubspanRepository courseSubspanRepository;
    private PersonRepository personRepository;
    private StationRepository stationRepository;
    private TicketRepository ticketRepository;
    private TrainRepository trainRepository;

    public RepositoryCollection(EntityManagerFactory emf) {
        this.courseRepository = new CourseRepository(emf);
        this.courseStationRepository = new CourseStationRepository(emf);
        this.courseSubspanRepository = new CourseSubspanRepository(emf);
        this.personRepository = new PersonRepository(emf);
        this.stationRepository = new StationRepository(emf);
        this.ticketRepository = new TicketRepository(emf);
        this.trainRepository = new TrainRepository(emf);
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public CourseStationRepository getCourseStationRepository() {
        return courseStationRepository;
    }

    public CourseSubspanRepository getCourseSubspanRepository() {
        return courseSubspanRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public TrainRepository getTrainRepository() {
        return trainRepository;
    }
}
