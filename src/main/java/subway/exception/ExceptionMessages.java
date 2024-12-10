package subway.exception;

public enum ExceptionMessages {
    NOT_EXIST_STATION("존재하지 않는 지하철역입니다. 다시 입력해주세요."),
    INVALID_MAIN_OPTION("잘못된 메인 옵션 선택 입력값입니다. 다시 입력해주세요."),
    INVALID_STANDARD_OPTION("잘못된 기준 옵션 선택 입력값입니다. 다시 입력해주세요."),
    BACK("돌아가기를 선택하셨습니다. 처음으로 돌아갑니다."),
    SAME_STATION("출발역과 도착역이 동일합니다.");

    private final String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return String.format("[ERROR] %s", message);
    }
}
