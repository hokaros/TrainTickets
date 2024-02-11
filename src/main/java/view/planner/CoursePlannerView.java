package view.planner;

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

        router.addOption("Dodaj pociąg", () -> {
            AddTrainView addTrainView = new AddTrainView(repositories.getTrainRepository());
            addTrainView.run();
        });

        router.addOption("Dodaj kurs", () -> {
            AddCourseView addCourseView = new AddCourseView(repositories);
            addCourseView.run();
        });

        router.addOption("Dodaj stację kursu", () -> {
            AddCourseStationView addCourseStationView = new AddCourseStationView(repositories);
            addCourseStationView.run();
        });

        while(true) {
            boolean shouldStay = router.run();

            if(!shouldStay)
                break;
        }
    }
}
