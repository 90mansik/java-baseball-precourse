package baseball.domain;

import baseball.constants.NumberRange;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("상대방(컴퓨터)의 기능 테스트")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp(){
        //given
        computer = new Computer();
        computer.setRandomNumbers();
    }


    @Test
    @DisplayName("난수의 자리수 검증")
    public void 난수_자리수_유효성체크(){
        //when

        List<Integer> result = computer.getRandomNumbers();
        //then
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
    @ParameterizedTest
    @DisplayName("난수가 숫자인지 체크한다.")
    @ValueSource(ints = {0,1,2})
    public void 난수_숫자_유효성체크(int index){
        //when
        String result = String.valueOf(computer.getRandomNumbers().get(index));
        //then
        Assertions.assertThat(Pattern.matches("^[0-9]*$",result )).isTrue();

    }

    @ParameterizedTest
    @DisplayName("난수의 값이 1~9 범위를 초과하면 Exception 발생 검증")
    @ValueSource(ints = {NumberRange.RANDOM_NUMBER_START-1, NumberRange.RANDOM_NUMBER_END+1})
    public void 난수_범위_유효성체크(int index){
        //when, then
        assertThatThrownBy(() -> {
          computer.validateNumberBoundary(index);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9범위의 숫자만 입력 가능합니다.");
    }


}