package view.planner;

import entity.Station;
import repository.StationRepository;

import java.util.Scanner;

public class AddStationView {

    private final StationRepository stationRepository;

    public AddStationView(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station run() {
        System.out.println("\n\n<<Nowa stacja>>");

        String name = promptName();

        Station station = new Station(name);
        stationRepository.add(station);

        System.out.println("Dodano stację");
        return station;
    }

    private String promptName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nazwa stacji:");

        while(true) {
            String name = scanner.nextLine();

            if(stationRepository.find(name) == null) {
                return name;
            }
            else {
                System.out.println("Stacja już istnieje");
            }
        }
    }
}
