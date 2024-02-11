package view.conductor;

import repository.TicketRepository;
import view.ViewRouter;

public class ConductorView {

    private TicketRepository ticketRepository;

    public ConductorView(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void run() {
        System.out.println("\n\n<<Widok konduktora>>");

        ViewRouter router = new ViewRouter();
        router.addOption("Sprawdź bilet", () -> {
            CheckTicketView checkTicketView = new CheckTicketView(ticketRepository);
            checkTicketView.run();
        });

        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }
}
