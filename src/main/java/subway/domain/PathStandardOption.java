package subway.domain;

import subway.exception.ExceptionMessages;

public enum PathStandardOption {
    DISTANCE("1", "최단 거리"),
    TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String optionNumber;
    private final String optionContent;

    PathStandardOption(String optionNumber, String optionContent){
        this.optionNumber = optionNumber;
        this.optionContent = optionContent;
    }

    public String getOptionNumber(){
        return optionNumber;
    }

    public String getOptionContent(){
        return optionContent;
    }

    public static PathStandardOption getPathStandardOption(String input){
        if (input.trim().equals(DISTANCE.optionNumber)){
            return DISTANCE;
        }
        if (input.trim().equals(TIME.optionNumber)){
            return TIME;
        }
        if (input.trim().equals(BACK.optionNumber)){
            return BACK;
        }
        throw new IllegalArgumentException(ExceptionMessages.INVALID_STANDARD_OPTION.getMessage());
    }
}
