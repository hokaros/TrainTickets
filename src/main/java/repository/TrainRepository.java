package repository;

import entity.Train;

import javax.persistence.EntityManagerFactory;

public class TrainRepository extends JpaRepository<Train, String> {

    public TrainRepository(EntityManagerFactory emf) {
        super(emf, Train.class);
    }
}
