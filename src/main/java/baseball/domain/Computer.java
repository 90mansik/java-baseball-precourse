package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers = new ArrayList<>();

    public static final int NUMBERS_SIZE_MAX = 3;
    public static final int RANDOM_NUMBER_START = 1;
    public static final int RANDOM_NUMBER_END = 9;

     public void setRandomNumbers(){
        while(randomNumbers.size() < NUMBERS_SIZE_MAX){
            int randomNumber = createRandomNumber();

            validateNumberBoundary(randomNumber);

            if(checkContainsNumber(randomNumber)){
                randomNumbers.add(randomNumber);
            }

        }
    }
    public int createRandomNumber(){
         return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }

    public boolean checkContainsNumber(int num){
         if(!randomNumbers.contains(num)){
            return true;
        }
        return false;
    }

    public List<Integer> getRandomNumbers(){
        return randomNumbers;
    }

    public void validateNumberBoundary(int number){
        if( number < RANDOM_NUMBER_START || number > RANDOM_NUMBER_END){
            throw new IllegalArgumentException("1~9범위의 숫자만 입력 가능합니다.");
        }

    }










}
