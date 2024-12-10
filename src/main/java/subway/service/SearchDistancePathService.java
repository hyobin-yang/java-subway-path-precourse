package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.DistancePathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.ShortestPathDTO;
import subway.validator.SubwayValidator;

import java.util.List;

public class SearchDistancePathService {

    private final DijkstraShortestPath distanceShortestPath;

    public SearchDistancePathService(){
        this.distanceShortestPath =  new DijkstraShortestPath(DistancePathRepository.getDistancePath());
    }

    public ShortestPathDTO search(String startStation, String endStation){
        SubwayValidator.validateNotSameStation(startStation, endStation);
        List<Station> shortestPath = distanceShortestPath.getPath(StationRepository.findStationByName(startStation), StationRepository.findStationByName(endStation)).getVertexList();
        double totalDistance = distanceShortestPath.getPath(StationRepository.findStationByName(startStation), StationRepository.findStationByName(endStation)).getWeight();
        return new ShortestPathDTO(shortestPath, totalDistance);
    }

    public double getDistanceWeight(List<Station> path){
        double totalWeight = 0;
        for (int i = 0; i < path.size()-1; i++){
            totalWeight += DistancePathRepository.getWeight(path.get(i), path.get(i+1));
        }
        return totalWeight;
    }

}
