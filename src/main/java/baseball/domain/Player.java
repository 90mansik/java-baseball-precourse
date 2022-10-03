package baseball.domain;

import java.util.*;
import java.util.regex.Pattern;


public class Player {

    public static final int RANDOM_NUMBER_START = 1;
    public static final int RANDOM_NUMBER_END = 9;
    private List<Integer> playNumbers = new ArrayList<>();

    private static Player player;

    public Player(){
    }

    public Player(String inputStr){
        setPlayNumbers(inputStr);
    }

    public void setPlayNumbers(String inputStr){
        checkValidatetion(inputStr);

        for(int i=0; i<inputStr.length(); i++){
            int playnumber = Integer.parseInt(inputStr.charAt(i)+"");

            playNumbers.add(playnumber);
        }
    }

    public List<Integer> getPlayNumbers(){
        return playNumbers;
    }
    public void checkValidatetion(String inputStr){
        validateStrSize(inputStr);
        validateIsNumberic(inputStr);
        validateNumberBoundary(inputStr);
        validateDuplicated(inputStr);
    }

    public void validateDuplicated(String inputStr){
        Set<Character> set = new HashSet<>();
        for( int i=0; i<inputStr.length(); i++){
            set.add(inputStr.charAt(i));
        }

        if(inputStr.length() != set.size()){
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }

    }
     public void validateIsNumberic(String inputStr){
        if(!Pattern.matches("^[0-9]*$",inputStr)){
            throw new IllegalArgumentException("1~9범위의 숫자만 입력 가능합니다.");
        }
    }


    public void validateNumberBoundary(String inputStr){
        for(int i=0; i<inputStr.length(); i++){
            int number = Character.getNumericValue(inputStr.charAt(i)) ;
            if(number < RANDOM_NUMBER_START || number > RANDOM_NUMBER_END){
                throw new IllegalArgumentException("1~9범위의 숫자만 입력 가능합니다.");
            }
        }
    }
    public void validateStrSize(String inputStr){
        if(inputStr == null ||  inputStr.length() != 3){
            throw new IllegalArgumentException("3자리를 입력 해 주시기 바랍니다.");
        }
    }


}
