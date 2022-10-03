package baseball.controller;

import baseball.constants.GameStatus;
import baseball.domain.BaseBallRule;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.PlayGameInputView;
import baseball.view.PlayGameOutputView;

public class BaseBallPlayController {

    private static BaseBallRule baseBallRule;
    private Player player;

    public void run(){

        GameStatus gameStatus = GameStatus.START;
        do{
            Computer computer = Computer.setupComputer();

            isPlayReTray(computer, player);

            gameStatus = selectGameMode().equals(GameStatus.END.getStatus()) ? GameStatus.END : GameStatus.START;

        }while(!gameStatus.equals(GameStatus.END));

        PlayGameOutputView.getGameFinishMessage();

    }

    public static void isPlayReTray(Computer computer, Player player){

        do{
            player = new Player(PlayGameInputView.inputNumbersByPlayer());

            baseBallRule = new BaseBallRule(computer.getRandomNumbers(), player.getPlayNumbers());
            baseBallRule.compareBall(computer.getRandomNumbers(), player.getPlayNumbers());

            PlayGameOutputView.getGameResultMessage(baseBallRule);
        }while(baseBallRule.getStrikeCount() != 3);

    }

    public static String selectGameMode() {
        return GameStatus.validateInputGameMode(PlayGameInputView.selectGameMode());
    }








}
