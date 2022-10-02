package study;


import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {



    @DisplayName("split: 문자열을 구분자 기준으로 배열로 반환 검증")
    @Test
    public void 문자열_split_테스트(){
        //given
        String str = "1,2";
        String str2 = "1";

        //when
        String[] resultArray = str.split(",");
        String[] resultArray2 = str2.split(",");

        //then
        //"1,2"를 ,로 split 했을때 1과 2로 잘 분리되는지 확인
        Assertions.assertThat(resultArray).contains("1","2");
        Assertions.assertThat(resultArray).containsExactly("1","2");

        //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인
        Assertions.assertThat(resultArray2).contains("1");
        Assertions.assertThat(resultArray2).containsExactly("1");
    }

    @DisplayName("subString: subString 메서드를 이용해 원하는 문자열 반환 검증 ")
    @Test
    public void 문자열_subString_테스트(){
        //given
        String str = "(1,2)";

        //when
        String result = str.substring(1,4);

        //then
        // "1,2"를 반환
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt: chat 메서드를 이용해 특정 위치의 문자를 반환 검증")
    @Test
    public void 문자열_charAt_테스트(){
        //given
        String str = "abc";

        //when
        char resultA = str.charAt(0);
        char resultB = str.charAt(1);
        char resultC = str.charAt(2);

        //then

        //문자열 str의 a,b,c를 반환 하는지 검증
        Assertions.assertThat(resultA).isEqualTo('a');
        Assertions.assertThat(resultB).isEqualTo('b');
        Assertions.assertThat(resultC).isEqualTo('c');
    }

    @DisplayName("charAt:  StringIndexOutOfBoundsException 검증")
    @Test
    public void 문자열_charAt_StringIndexOutofBoundsException_테스트(){
        //given
        String str = "abc";

        //when, then
        // 입력값 범위 밖일 경우 StringIndexOutOfBoundsException 검증
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(str.length()));
    }

}
