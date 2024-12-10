package subway.domain;

import subway.exception.ExceptionMessages;

public enum MainOption {
    SEARCH_PATH("1", "경로 조회"),
    QUIT("Q", "종료");

    private final String optionNumber;
    private final String optionContent;

    MainOption(String optionNumber, String optionContent){
        this.optionNumber = optionNumber;
        this.optionContent = optionContent;
    }

    public String getOptionNumber(){
        return optionNumber;
    }

    public String getOptionContent(){
        return optionContent;
    }

    public static MainOption getMainOption(String input){
        if (input.trim().equals(SEARCH_PATH.optionNumber)){
            return SEARCH_PATH;
        }
        if (input.trim().equals(QUIT.optionNumber)){
            return QUIT;
        }
        throw new IllegalArgumentException(ExceptionMessages.INVALID_MAIN_OPTION.getMessage());
    }

}
