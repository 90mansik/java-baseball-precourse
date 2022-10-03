package baseball.view;

import baseball.constants.PrintGameMessage;
import baseball.domain.BaseBallRule;

public class PrintGameMessageView {

    public static void printInputNumberMessage(){
        System.out.print(PrintGameMessage.INPUT_NUMBER);
    }
    
    public static void printSuccessGameMessage(){
        System.out.println(PrintGameMessage.SUCCESS_GAME);
    }
    
    public static void printSelectGameModeMessage(){
        System.out.println(PrintGameMessage.SELECT_GAME_MODE);
    }




}
