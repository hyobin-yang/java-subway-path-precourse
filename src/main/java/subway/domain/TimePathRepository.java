package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimePathRepository {
    private static final WeightedMultigraph<Station, Integer> timePath = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station){
        timePath.addVertex(station);
    }

    public static void addEdge(Station startStation, Station endStation, Integer time){
        timePath.setEdgeWeight(timePath.addEdge(startStation, endStation), time);
    }

    public static WeightedMultigraph<Station, Integer> getTimePath(){
        return timePath;
    }

    public static double getWeight(Station startStation, Station endStation){
        return timePath.getEdge(startStation, endStation);
    }
}
