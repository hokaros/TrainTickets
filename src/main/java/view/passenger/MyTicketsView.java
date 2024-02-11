package view.passenger;

import entity.Person;
import entity.Ticket;
import repository.TicketRepository;
import view.ViewRouter;

public class MyTicketsView {

    private final Person user;
    private final TicketRepository ticketRepository;

    public MyTicketsView(Person user, TicketRepository ticketRepository) {
        this.user = user;
        this.ticketRepository = ticketRepository;
    }

    public void run() {
        System.out.println("\n\n<<Moje bilety>>");

        for(Ticket ticket : ticketRepository.getTicketsByOwner(user)) {
            System.out.println(ticket);
        }

        ViewRouter router = new ViewRouter();
        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }
}
