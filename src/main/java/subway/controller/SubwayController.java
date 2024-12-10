package subway.controller;

import subway.domain.MainOption;
import subway.domain.PathStandardOption;
import subway.dto.ResultDTO;
import subway.dto.ShortestPathDTO;
import subway.handler.RetryHandler;
import subway.io.DateProvider;
import subway.service.SearchDistancePathService;
import subway.service.SearchTimePathService;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class SubwayController {

    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final SubwayService subwayService;
    private final SearchTimePathService searchTimePathService;
    private final SearchDistancePathService searchDistancePathService;

    public SubwayController(InputView inputView, OutputView outputView, SubwayService subwayService, SearchTimePathService searchTimePathService, SearchDistancePathService searchDistancePathService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.subwayService = subwayService;
        this.searchTimePathService = searchTimePathService;
        this.searchDistancePathService = searchDistancePathService;
    }

    public void initializeSubwayData(){
        initializeStations(DateProvider.provideStations());
        initializeLines(DateProvider.provideLines());
        subwayService.addVertex();
        initializeTimeEdges(DateProvider.provideTimePath());
        initializeDistanceEdges(DateProvider.provideDistancePath());
    }

    private void initializeStations(List<String> stations){
        for (String station : stations){
            subwayService.addStation(station);
        }
    }

    private void initializeLines(List<String> lines){
        for (String line : lines){
            subwayService.addLine(line);
        }
    }

    private void initializeTimeEdges(List<String> timeEdges){
        for (String rawTimeEdge : timeEdges){
            List<String> timeEdge = Arrays.asList(rawTimeEdge.split(DELIMITER));
            subwayService.addTimeEdge(timeEdge.get(1), timeEdge.get(2), Integer.parseInt(timeEdge.get(3)));
        }
    }

    private void initializeDistanceEdges(List<String> distanceEdges){
        for (String rawDistanceEdge : distanceEdges){
            List<String> distanceEdge = Arrays.asList(rawDistanceEdge.split(DELIMITER));
            subwayService.addDistanceEdge(distanceEdge.get(1), distanceEdge.get(2), Integer.parseInt(distanceEdge.get(3)));
        }
    }

    public void run(){
        RetryHandler.retryWithoutReturn(this::startFindingPath);
    }

    private void startFindingPath(){
        showMainOptionMessage();
        if (RetryHandler.retryWithReturn(this::chooseMainOption).equals(MainOption.SEARCH_PATH)){
            RetryHandler.retryWithoutReturn(this::searchPath);
        }
    }

    private void showMainOptionMessage(){
        outputView.showMainOptionMessage();
        outputView.showMainOption(MainOption.SEARCH_PATH.getOptionNumber(), MainOption.SEARCH_PATH.getOptionContent());
        outputView.showMainOption(MainOption.QUIT.getOptionNumber(), MainOption.QUIT.getOptionContent());
    }

    private MainOption chooseMainOption(){
        String mainOptionChoice = inputView.inputOptionChoice();
        return MainOption.getMainOption(mainOptionChoice);
    }

    private void searchPath(){
        showPathStandardOptionMessage();
        PathStandardOption standardOption = RetryHandler.retryWithReturn(this::chooseStandardOption);
        String startStation = inputView.inputStartStation();
        String endStation = inputView.inputEndStation();
        if (standardOption.equals(PathStandardOption.DISTANCE)){
            getShortestDistancePath(startStation, endStation);
        }
        if (standardOption.equals(PathStandardOption.TIME)){
            getShortestTimePath(startStation, endStation);
        }
        run();
    }

    private void showPathStandardOptionMessage(){
        outputView.showPathStandardOptionMessage();
        outputView.showStandardOption(PathStandardOption.DISTANCE.getOptionNumber(), PathStandardOption.DISTANCE.getOptionContent());
        outputView.showStandardOption(PathStandardOption.TIME.getOptionNumber(), PathStandardOption.TIME.getOptionContent());
    }

    private PathStandardOption chooseStandardOption(){
        String standardOptionChoice = inputView.inputOptionChoice();
        return PathStandardOption.getPathStandardOption(standardOptionChoice);
    }

    private void getShortestDistancePath(String startStation, String endStation){
        ShortestPathDTO dto = searchDistancePathService.search(startStation, endStation);
        double timeWeight = searchTimePathService.getTimeWeight(dto.getShortestPath());
        printResult(new ResultDTO(dto.getWeight(), timeWeight, dto.getShortestPathInStationName()));
    }

    private void getShortestTimePath(String startStation, String endStation){
        ShortestPathDTO dto = searchTimePathService.search(startStation, endStation);
        double distanceWeight = searchDistancePathService.getDistanceWeight(dto.getShortestPath());
        printResult(new ResultDTO(distanceWeight, dto.getWeight(), dto.getShortestPathInStationName()));
    }

    private void printResult(ResultDTO resultDTO){
        outputView.showResult(resultDTO.getTotalDistanceWeight(), resultDTO.getTotalTimeWeight(), resultDTO.getStations());
    }


}
