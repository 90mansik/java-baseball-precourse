package baseball.view;

import baseball.domain.BaseBallRule;
import camp.nextstep.edu.missionutils.Console;

public class PlayGameInputView {

    public static String inputNumbersByPlayer() {
        PrintGameMessageView.printInputNumberMessage();
        return Console.readLine();
    }

    public static String selectGameMode(){
        PrintGameMessageView.printSuccessGameMessage();
        PrintGameMessageView.printSelectGameModeMessage();
        return Console.readLine();
    }

}
