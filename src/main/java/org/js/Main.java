package org.js;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Person;
import repository.PersonRepository;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proBD");

        PersonRepository personRepo = new PersonRepository(emf);

        Person p1 = new Person("std@email.com", "Jan", "Zamoyski");

        personRepo.add(p1);

        for(Person p : personRepo.getAll()) {
            System.out.println(p);
        }

        emf.close();
    }
}