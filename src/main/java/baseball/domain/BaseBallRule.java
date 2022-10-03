package baseball.domain;

import java.util.List;

/*
 * 야구 규칙
 */
public class BaseBallRule {

    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers;
    private int strikeCount;
    private int ballCount;



    public BaseBallRule(List<Integer> computerNumbers, List<Integer> playerNumbers){
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
        this.ballCount = 0;
        this.strikeCount = 0;

    }

    public int countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers){
        for(int i=0; i<computerNumbers.size(); i++){
            if(computerNumbers.get(i).equals(playerNumbers.get(i))){
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public int countBall(List<Integer> computerNumbers, List<Integer> playerNumbers){
        for(int i=0; i<computerNumbers.size(); i++){
            if(computerNumbers.contains(playerNumbers.get(i)) ){
                ballCount++;
            }
        }

        return ballCount-strikeCount;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

    public int getBallCount(){
        return ballCount;
    }


}
