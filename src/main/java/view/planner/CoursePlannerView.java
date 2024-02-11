package view.planner;

import repository.PersonRepository;
import repository.RepositoryCollection;
import view.ViewRouter;

public class CoursePlannerView {

    private RepositoryCollection repositories;

    public CoursePlannerView(RepositoryCollection repositories) {
        this.repositories = repositories;
    }

    public void run() {
        System.out.println("\n\n<<Widok planisty>>");

        ViewRouter router = new ViewRouter();
        router.addOption("Dodaj stację", () -> {
            AddStationView addStationView = new AddStationView(repositories.getStationRepository());
            addStationView.run();
        });


        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }
}
