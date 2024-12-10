package subway.config;

import subway.controller.SubwayController;
import subway.service.SearchDistancePathService;
import subway.service.SearchTimePathService;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class AppConfig {

    private final Scanner scanner;

    public AppConfig(Scanner scanner){
        this.scanner = scanner;
    }

    private InputView inputView(){
        return new InputView(scanner);
    }

    private OutputView outputView(){
        return new OutputView();
    }

    private SubwayService subwayService(){
        return new SubwayService();
    }

    private SearchTimePathService searchTimePathService(){
        return new SearchTimePathService();
    }

    private SearchDistancePathService searchDistancePathService(){
        return new SearchDistancePathService();
    }

    public SubwayController controller() {
        return new SubwayController(inputView(), outputView(), subwayService(), searchTimePathService(), searchDistancePathService());
    }
}
