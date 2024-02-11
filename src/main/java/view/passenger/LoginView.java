package view.passenger;

import entity.Person;
import repository.PersonRepository;

import java.util.Scanner;

public class LoginView {

    private PersonRepository personRepository;

    public LoginView(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person run() {
        System.out.println("\n\nLogowanie");

        String email = promptEmail();

        return personRepository.find(email);
    }

    private String promptEmail() {
        System.out.println("Adres e-mail:");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String email = scanner.nextLine();

            if(personRepository.find(email) == null) {
                System.out.println("Użytkownik nie istnieje");
            }
            else {
                return email;
            }
        }
    }
}
