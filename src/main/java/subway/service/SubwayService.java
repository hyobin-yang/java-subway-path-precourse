package subway.service;

import subway.domain.*;

public class SubwayService {

    public void addStation(String stationName){
        StationRepository.addStation(new Station(stationName));
    }

    public void addLine(String lineName){
        LineRepository.addLine(new Line(lineName));
    }

    public void addVertex(){
        for(Station station : StationRepository.stations()){
            DistancePathRepository.addVertex(station);
            TimePathRepository.addVertex(station);
        }
    }

    public void addTimeEdge(String startStationName, String endStationName, Integer time){
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        TimePathRepository.addEdge(startStation, endStation, time);
    }

    public void addDistanceEdge(String startStationName, String endStationName, Integer distance){
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        DistancePathRepository.addEdge(startStation, endStation, distance);
    }

}
