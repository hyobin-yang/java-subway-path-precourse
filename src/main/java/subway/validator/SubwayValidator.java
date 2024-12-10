package subway.validator;

import subway.exception.ExceptionMessages;

public class SubwayValidator {

    public static void validateNotSameStation(String startStation, String endStation){
        if (startStation.equals(endStation)){
            throw new IllegalArgumentException(ExceptionMessages.SAME_STATION.getMessage());
        }
    }

}
