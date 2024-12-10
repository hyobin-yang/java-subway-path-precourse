package subway.dto;

import java.util.List;

public class ResultDTO {

    private final double totalDistanceWeight;
    private final double totalTimeWeight;
    private final List<String> stations;

    public ResultDTO(double totalDistanceWeight, double totalTimeWeight, List<String> stations){
        this.totalDistanceWeight = totalDistanceWeight;
        this.totalTimeWeight = totalTimeWeight;
        this.stations = stations;
    }

    public double getTotalDistanceWeight(){
        return totalDistanceWeight;
    }

    public double getTotalTimeWeight(){
        return totalTimeWeight;
    }

    public List<String> getStations(){
        return stations;
    }
}
