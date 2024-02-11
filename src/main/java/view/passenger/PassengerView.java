package view.passenger;

import entity.Person;
import repository.PersonRepository;

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
            boolean shouldExit = false;

            if(loggedPassenger == null) {
                shouldExit = showNotLoggedPanel();
            }
            else {
                shouldExit = showPassengerMenu();
            }

            if(shouldExit)
                break;
        }
    }

    private boolean showNotLoggedPanel() {
        System.out.println("1. Zaloguj się");
        System.out.println("2. Zarejestruj się");
        System.out.println("3. Wyjdź");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("1")) {
            // TODO: logowanie
        }
        else if(choice.equals("2")) {
            RegistrationView registrationView = new RegistrationView(personRepository);
            loggedPassenger = registrationView.run();
        }
        else if(choice.equals("3")) {
            return false;
        }
        else {
            System.out.println("Niepoprawna opcja");
        }

        return true;
    }

    private boolean showPassengerMenu() {
        System.out.println("1. Moje bilety");
        System.out.println("2. Szukaj kursu");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("1")) {
            // TODO: moje bilety
        }
        else if(choice.equals("2")) {
            // TODO: szukaj kursu
        }
        else if(choice.equals("3")) {
            return false;
        }
        else {
            System.out.println("Niepoprawna opcja");
        }

        return true;
    }
}
