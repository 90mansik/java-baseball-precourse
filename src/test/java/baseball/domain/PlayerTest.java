package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("플레이어의 기능 테스트")
class PlayerTest {

    private Player player;

    public static final int RANDOM_NUMBER_START = 1;
    public static final int RANDOM_NUMBER_END = 9;

    @BeforeEach
    public void setUp(){
        //given
        player = new Player();
    }


    @ParameterizedTest
    @DisplayName("입력받은 문자 길이가 3인지 검증")
    @ValueSource(strings = {"1","","12","1234"})
    public void 플레이어_길이_Exception_테스트(String inputStr) {

        //when, then
        assertThatThrownBy(() -> {
            player.validateStrSize(inputStr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리를 입력 해 주시기 바랍니다.");
    }

    @ParameterizedTest
    @DisplayName("입력받은 문자가 숫자인지 검증")
    @ValueSource(strings = {"11a", "aaa", "*12", "1q*", "13a"} )
    public void 플레이어_숫자_Exception_테스트(String inputStr) {

        //when, then
        assertThatThrownBy(() -> {
            player.validateIsNumberic(inputStr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9범위의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("입력받은 문자가 1~9까지 범위인지 검증")
    @ValueSource(strings = {"0", "10"})
    public void 플레이어_숫자범위_Exception_테스트(String inputNumber) {

        //when, then
        assertThatThrownBy(() -> {
            player.validateNumberBoundary(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9범위의 숫자만 입력 가능합니다.");
    }




    @Test
    @DisplayName("입력받은 문자가 숫자인지 체크한다.")
    public void 플레이어_중복문자_Exception_테스트() {
        //given
        String inputStr = "112";
        //when, then
        assertThatThrownBy(() -> {
            player.validateDuplicated(inputStr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("플레이어가 입력한 문자가 List<Integer>로저장되는지 검증")
    public void 플레이어_입력문자_셋팅_테스트(){
        //given
        String inputStr = "476";

        //when
        player.setPlayNumbers(inputStr);

        //then
        Assertions.assertThat(player.getPlayNumbers().get(0)).isEqualTo(4);
        Assertions.assertThat(player.getPlayNumbers().get(1)).isEqualTo(7);
        Assertions.assertThat(player.getPlayNumbers().get(2)).isEqualTo(6);

    }

}