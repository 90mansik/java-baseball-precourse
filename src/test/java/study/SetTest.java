package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    @DisplayName("size: Set 크기를 검증")
    public void set_size_테스트(){

        //when
        int result = numbers.size();

        //then
        Assertions.assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("contains: Set에 원하는 값이 있는지 검증")
    public void set_contains_테스트(){

        //when, then

        //set의 포함되어 있는 숫자인 경우(1,2,3)은 true를 리턴
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();

        //set의 포함되어 있는 숫자인 경우(4)은 false를 리턴
        Assertions.assertThat(numbers.contains(4)).isFalse();

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("ParameterizedTest를 통한 Set에 원하는 값이 있는지 검증 ")
    public void set_contains_중복코드제거(int given){

        //when, then
        Assertions.assertThat(numbers.contains(given)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter=':')
    @DisplayName("Set에 원하는 값 포함/미포함을 검증")
    public void set_contains_cvsSource테스트(String given, String expected){
        //when, then
        Assertions.assertThat(numbers.contains(Integer.parseInt(given))).isEqualTo(Boolean.parseBoolean(expected));
    }


}
