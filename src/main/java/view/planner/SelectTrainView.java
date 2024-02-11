package view.planner;

import entity.Train;
import repository.TrainRepository;
import view.EntitySelectionView;

import java.util.List;

public class SelectTrainView extends EntitySelectionView<Train> {

    private TrainRepository trainRepository;

    public SelectTrainView(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    protected List<Train> getAll() {
        return trainRepository.getAll();
    }

    @Override
    protected void printTitle() {
        System.out.println("Wybierz pociąg:");
    }
}
