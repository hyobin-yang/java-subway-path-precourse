package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistancePathRepository {
    private static final WeightedMultigraph<Station, Integer> distancePath = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station){
        distancePath.addVertex(station);
    }

    public static void addEdge(Station startStation, Station endStation, Integer distance){
        distancePath.setEdgeWeight(distancePath.addEdge(startStation, endStation), distance);
    }

    public static WeightedMultigraph<Station, Integer> getDistancePath(){
        return distancePath;
    }

    public static double getWeight(Station startStation, Station endStation){
        return distancePath.getEdge(startStation, endStation);
    }
}
