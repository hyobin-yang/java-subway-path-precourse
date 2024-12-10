package subway.io;

import java.util.List;

public class DateProvider {

    private static final String STATIONS = "src/main/java/subway/resource/providedStations";
    private static final String LINES = "src/main/java/subway/resource/providedLines";
    private static final String DISTANCE_PATH = "src/main/java/subway/resource/providedDistancePath";
    private static final String TIME_PATH = "src/main/java/subway/resource/providedTimePath";

    public static List<String> provideStations(){
        return FileReader.read(STATIONS);
    }

    public static List<String> provideLines(){
        return FileReader.read(LINES);
    }

    public static List<String> provideDistancePath(){
        return FileReader.read(DISTANCE_PATH);
    }

    public static List<String> provideTimePath(){
        return FileReader.read(TIME_PATH);
    }
}
