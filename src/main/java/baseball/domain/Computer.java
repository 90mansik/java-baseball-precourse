package baseball.domain;

import baseball.constants.NumberRange;
import baseball.constants.PrintGameMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers = new ArrayList<>();

     public void setRandomNumbers(){
        while(randomNumbers.size() < NumberRange.NUMBERS_SIZE_MAX){
            int randomNumber = createRandomNumber();

            validateNumberBoundary(randomNumber);

            if(checkContainsNumber(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumbers(){
         return randomNumbers;
    }
    public int createRandomNumber(){
         return Randoms.pickNumberInRange(NumberRange.RANDOM_NUMBER_START, NumberRange.RANDOM_NUMBER_END);
    }

    public boolean checkContainsNumber(int num){
         if(!randomNumbers.contains(num)){
            return true;
        }
        return false;
    }

    public List<Integer> getRandomNumber(){
        return randomNumbers;
    }

    public void validateNumberBoundary(int number){
        if( number < NumberRange.RANDOM_NUMBER_START || number > NumberRange.RANDOM_NUMBER_END){
            throw new IllegalArgumentException(PrintGameMessage.INVALID_NUMBER_BOUNDARY);
        }
    }

}
