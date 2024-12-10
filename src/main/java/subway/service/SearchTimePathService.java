package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimePathRepository;
import subway.dto.ShortestPathDTO;
import subway.validator.SubwayValidator;

import java.util.Collections;
import java.util.List;

public class SearchTimePathService {

    private final DijkstraShortestPath timeShortestPath;

    public SearchTimePathService(){
        this.timeShortestPath =  new DijkstraShortestPath(TimePathRepository.getTimePath());
    }

    public ShortestPathDTO search(String startStation, String endStation){
        SubwayValidator.validateNotSameStation(startStation, endStation);
        List<Station> shortestPath = timeShortestPath.getPath(StationRepository.findStationByName(startStation), StationRepository.findStationByName(endStation)).getVertexList();
        double totalTime = timeShortestPath.getPath(StationRepository.findStationByName(startStation), StationRepository.findStationByName(endStation)).getWeight();
        return new ShortestPathDTO(Collections.unmodifiableList(shortestPath), totalTime);
    }

    public double getTimeWeight(List<Station> path){
        double totalWeight = 0;
        for (int i = 0; i < path.size()-1; i++){
            totalWeight += TimePathRepository.getWeight(path.get(i), path.get(i+1));
        }
        return totalWeight;
    }
}
