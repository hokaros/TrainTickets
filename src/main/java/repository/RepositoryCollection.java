package repository;

import javax.persistence.EntityManagerFactory;

public class RepositoryCollection {

    private PersonRepository personRepository;

    public RepositoryCollection(EntityManagerFactory emf) {
        this.personRepository = new PersonRepository(emf);
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
