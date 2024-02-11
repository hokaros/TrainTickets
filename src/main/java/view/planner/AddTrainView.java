package view.planner;

import entity.Train;
import repository.TrainRepository;

import java.util.Scanner;

public class AddTrainView {

    private final TrainRepository trainRepository;

    public AddTrainView(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train run() {
        System.out.println("\n\n<<Nowy pociąg>>");

        String trainNumber = promptTrainNumber();

        Train train = new Train(trainNumber);
        trainRepository.add(train);

        System.out.println("Dodano pociąg");
        return train;
    }

    private String promptTrainNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numer pociągu:");

        while(true) {
            String trainNumber = scanner.nextLine();

            if(trainRepository.find(trainNumber) == null) {
                return trainNumber;
            }
            else {
                System.out.println("Pociąg już istnieje");
            }
        }
    }
}
