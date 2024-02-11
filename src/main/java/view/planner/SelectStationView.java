package view.planner;

import entity.Station;
import repository.StationRepository;
import view.EntitySelectionView;

import java.util.List;

public class SelectStationView extends EntitySelectionView<Station> {

    private StationRepository stationRepository;

    public SelectStationView(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    protected List<Station> getAll() {
        return stationRepository.getAll();
    }

    @Override
    protected void printTitle() {
        System.out.println("Wybierz stację:");
    }
}
