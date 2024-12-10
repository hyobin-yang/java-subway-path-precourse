package subway.dto;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestPathDTO {

    private final List<Station> shortestPath;
    private final double weight;

    public ShortestPathDTO(List<Station> shortestPath, double weight){
        this.shortestPath = shortestPath;
        this.weight = weight;
    }

    public List<Station> getShortestPath(){
        return shortestPath;
    }

    public List<String> getShortestPathInStationName(){
        List<String> path = new ArrayList<>();
        for (Station station : shortestPath){
            path.add(station.getName());
        }
        return Collections.unmodifiableList(path);
    }

    public double getWeight(){
        return weight;
    }
}
