package org.js;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Person;
import repository.PersonRepository;
import view.passenger.PassengerView;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proBD");

        PersonRepository personRepo = new PersonRepository(emf);

        // TODO: możliwość wyboru między widokiem pasażera, konduktora a planisty
        PassengerView passengerView = new PassengerView(personRepo);
        passengerView.run();

        emf.close();
    }
}