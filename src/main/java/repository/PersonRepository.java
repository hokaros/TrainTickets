package repository;

import entity.Person;

import javax.persistence.EntityManagerFactory;

public class PersonRepository extends JpaRepository<Person, String>{

    public PersonRepository(EntityManagerFactory emf) {
        super(emf, Person.class);
    }
}
