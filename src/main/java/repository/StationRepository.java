package repository;

import entity.Station;

import javax.persistence.EntityManagerFactory;

public class StationRepository extends JpaRepository<Station, String> {

    public StationRepository(EntityManagerFactory emf) {
        super(emf, Station.class);
    }
}
