package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistancePathRepository {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distancePath = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station){
        distancePath.addVertex(station);
    }

    public static void addEdge(Station startStation, Station endStation, double distance){
        distancePath.setEdgeWeight(distancePath.addEdge(startStation, endStation), distance);
    }

    public static WeightedMultigraph<Station, DefaultWeightedEdge> getDistancePath(){
        return distancePath;
    }

}
