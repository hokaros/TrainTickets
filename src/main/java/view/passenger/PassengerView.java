package view.passenger;

import entity.Person;
import repository.RepositoryCollection;
import view.ViewRouter;

public class PassengerView {

    private Person loggedPassenger = null;

    private RepositoryCollection repositories;

    public PassengerView(RepositoryCollection repositories) {
        this.repositories = repositories;
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
            LoginView loginView = new LoginView(repositories.getPersonRepository());
            loggedPassenger = loginView.run();
        });

        viewRouter.addOption("Zarejestruj się", () -> {
            RegistrationView registrationView = new RegistrationView(repositories.getPersonRepository());
            loggedPassenger = registrationView.run();
        });

        return viewRouter.run();
    }

    private boolean showPassengerMenu() {
        ViewRouter viewRouter = new ViewRouter();

        viewRouter.addOption("Moje bilety", () -> {
            MyTicketsView myTicketsView = new MyTicketsView(loggedPassenger, repositories.getTicketRepository());
            myTicketsView.run();
        });

        viewRouter.addOption("Kup bilet", () -> {
            BuyTicketView buyTicketView = new BuyTicketView(loggedPassenger, repositories);
            buyTicketView.run();
        });

        return viewRouter.run();
    }
}
