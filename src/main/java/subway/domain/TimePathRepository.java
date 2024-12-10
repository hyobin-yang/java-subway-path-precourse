package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimePathRepository {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timePath = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station){
        timePath.addVertex(station);
    }

    public static void addEdge(Station startStation, Station endStation, double time){
        timePath.setEdgeWeight(timePath.addEdge(startStation, endStation), time);
    }

    public static WeightedMultigraph<Station, DefaultWeightedEdge> getTimePath(){
        return timePath;
    }
    
}
