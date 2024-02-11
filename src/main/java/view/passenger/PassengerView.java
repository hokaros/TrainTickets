package view.passenger;

import entity.Person;
import repository.PersonRepository;
import view.ViewRouter;

import java.util.Scanner;

public class PassengerView {

    private Person loggedPassenger = null;

    private PersonRepository personRepository;

    public PassengerView(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void run() {
        System.out.println("\n\n<<Widok pasażera>>");

        while(true) {
            boolean shouldStay = false;

            if(loggedPassenger == null) {
                shouldStay = showNotLoggedPanel();
            }
            else {
                shouldStay = showPassengerMenu();
            }

            if(!shouldStay)
                break;
        }
    }

    private boolean showNotLoggedPanel() {
        ViewRouter viewRouter = new ViewRouter();

        viewRouter.addOption("Zaloguj się", () -> {
            System.out.println("TODO: logowanie"); // TODO: logowanie
        });

        viewRouter.addOption("Zarejestruj się", () -> {
            RegistrationView registrationView = new RegistrationView(personRepository);
            loggedPassenger = registrationView.run();
        });

        return viewRouter.run();
    }

    private boolean showPassengerMenu() {
        ViewRouter viewRouter = new ViewRouter();

        viewRouter.addOption("Moje bilety", () -> {
            System.out.println("TODO: moje bilety"); // TODO: moje bilety
        });

        viewRouter.addOption("Szukaj kursu", () -> {
            System.out.println("TODO: szukaj kursu"); // TODO: szukaj kursu
        });

        return viewRouter.run();
    }
}
