package view;

import repository.RepositoryCollection;
import view.conductor.ConductorView;
import view.passenger.PassengerView;
import view.planner.CoursePlannerView;

public class MainView {

    private RepositoryCollection repositories;

    public MainView(RepositoryCollection repositories) {
        this.repositories = repositories;
    }

    public void run() {
        ViewRouter router = new ViewRouter();

        router.addOption("Pasażer", () -> {
            PassengerView passengerView = new PassengerView(repositories);
            passengerView.run();
        });

        router.addOption("Planista", () -> {
            CoursePlannerView coursePlannerView = new CoursePlannerView(repositories);
            coursePlannerView.run();
        });

        router.addOption("Konduktor", () -> {
            ConductorView conductorView = new ConductorView(repositories.getTicketRepository());
            conductorView.run();
        });

        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }
}
