package baseball.view;

import baseball.constants.PrintGameMessage;
import baseball.domain.BaseBallRule;

public class PlayGameOutputView {


    public static void getGameResultMessage(BaseBallRule baseBallRule){
        System.out.println(baseBallRule.getGameResultString());
    }

    public static void getGameFinishMessage(){
        System.out.println(PrintGameMessage.GAME_FINISH);
    }
}
