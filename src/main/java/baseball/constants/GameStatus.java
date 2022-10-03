package baseball.constants;

public enum GameStatus {

    START("1"),
    END("2"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTTING("낫싱");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }


    public static String validateInputGameMode(String inputStr){
        if( !START.getStatus().equals(inputStr) && !END.getStatus().equals(inputStr)){
            throw new IllegalArgumentException(PrintGameMessage.GAME_MODE_EXCEPTION);
        }
        return inputStr;
    }
}
