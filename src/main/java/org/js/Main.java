package org.js;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.RepositoryCollection;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proBD");

        RepositoryCollection repositories = new RepositoryCollection(emf);

        MainView view = new MainView(repositories);
        view.run();

        emf.close();
    }
}