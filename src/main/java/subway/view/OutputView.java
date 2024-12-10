package subway.view;

import java.util.List;

public class OutputView {

    private static final String INFO = "[INFO]";

    public void showMainOptionMessage(){
        System.out.println("## 메인 화면");
    }

    public void showMainOption(String optionNumber, String optionContent){
        System.out.printf("%s. %s\n", optionNumber, optionContent);
    }

    public void showPathStandardOptionMessage(){
        System.out.println("## 경로 기준");
    }

    public void showStandardOption(String optionNumber, String optionContent){
        System.out.printf("%s. %s\n", optionNumber, optionContent);
    }

    public void showResult(double totalDistanceWeight, double totalTimeWeight, List<String> stations){
        System.out.println("## 조회 결과");
        System.out.println(INFO + " ---");
        System.out.println(INFO + " 총 거리: " + Math.round(totalDistanceWeight) + "km");
        System.out.println(INFO + " 총 소요 시간: " + Math.round(totalTimeWeight) + "분");
        System.out.println(INFO + " ---");
        for (String station : stations){
            System.out.println(INFO + " " + station);
        }
    }

    public void breakLine(){
        System.out.println();
    }
}
