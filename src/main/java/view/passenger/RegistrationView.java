package view.passenger;

import entity.Person;
import repository.PersonRepository;

import java.util.Scanner;

public class RegistrationView {

    private Scanner scanner = new Scanner(System.in);
    private PersonRepository personRepository;

    public RegistrationView(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person run() {
        System.out.println("\n\n<<Rejestracja>>");

        String email = promptEmail();
        String name = promptName();
        String surname = promptSurname();

        Person person = new Person(email, name, surname);
        personRepository.add(person);
        return person;
    }

    private String promptEmail() {
        System.out.println("Adres e-mail:");

        while(true) {
            String email = scanner.nextLine();

            if(personRepository.find(email) == null) {
                return email;
            }
            else {
                System.out.println("Adres zajęty");
            }
        }
    }

    private String promptName() {
        System.out.println("Imię:");
        return scanner.nextLine();
    }

    private String promptSurname() {
        System.out.println("Nazwisko:");
        return scanner.nextLine();
    }
}
