package view.conductor;

import entity.Ticket;
import repository.TicketRepository;
import view.ViewRouter;

import java.util.Scanner;

public class CheckTicketView {

    private TicketRepository ticketRepository;

    public CheckTicketView(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void run() {
        Ticket ticket = promptTicket();

        if(ticket == null) {
            System.out.println("Nie znaleziono biletu");
        }
        else {
            System.out.println(ticket);
        }

        ViewRouter router = new ViewRouter();

        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }

    private Ticket promptTicket() {
        System.out.println("Podaj id biletu:");

        Scanner scanner = new Scanner(System.in);
        Long ticketId = scanner.nextLong();

        return ticketRepository.find(ticketId);
    }
}
