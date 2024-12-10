package subway;

import subway.config.AppConfig;
import subway.controller.SubwayController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        AppConfig appConfig = new AppConfig(scanner);
        SubwayController controller = appConfig.controller();
        controller.initializeSubwayData();
        controller.run();
    }
}
