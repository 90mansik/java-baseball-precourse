package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 규칙 기능 테스트")
class BaseBallRuleTest {

    private BaseBallRule baseBallRule;
    List<Integer> computerNumbers;
    List<Integer> playerNumbers;

    private int strikeCount;
    private int ballCount;

    @BeforeEach
    void setUp(){
        // given, when
        computerNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
        baseBallRule = new BaseBallRule(computerNumbers, playerNumbers);
        strikeCount = 0;
        ballCount = 0;
    }

    void setCount(int strikeCount, int ballCount){
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    @Test
    @DisplayName("스트라이크 카운트 갯수를 검증")
    public void 스트라이크_카운트_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 456
        playerNumbers = Arrays.asList(4,5,6);

        //when
        strikeCount = baseBallRule.countStrike(computerNumbers, playerNumbers);

        //then
        Assertions.assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 카운트 갯수를 검증")
    public void 볼_카운트_테스트(){
        //given
        //상대방(컴퓨터)의 수가 197
        computerNumbers =  Arrays.asList(1,9,7);
        //플레이어의 입력 값이 671
        playerNumbers = Arrays.asList(6,7,1);

        //when
        ballCount = baseBallRule.countBall(computerNumbers, playerNumbers);

        //then
        Assertions.assertThat(ballCount).isEqualTo(2);
    }


    @Test
    @DisplayName("같은 수가 전혀 없을 경우 낫싱 리턴 검증")
    public void 낫싱_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 789
        playerNumbers = Arrays.asList(7,8,9);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(0);
        Assertions.assertThat(ballCount).isEqualTo(0);
    }


    @Test
    @DisplayName("원볼 검증")
    public void 원볼_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 156
        playerNumbers = Arrays.asList(1,5,6);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(0);
        Assertions.assertThat(ballCount).isEqualTo(1);
    }

    @Test
    @DisplayName("투볼 검증")
    public void 투볼_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 154
        playerNumbers = Arrays.asList(1,5,4);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(0);
        Assertions.assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("쓰리볼 검증")
    public void 쓰리볼_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 542
        playerNumbers = Arrays.asList(5,4,2);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(0);
        Assertions.assertThat(ballCount).isEqualTo(3);
    }
    
    @Test
    @DisplayName("원스트라이크 검증")
    public void 원스트라이크_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 165
        playerNumbers = Arrays.asList(1,6,5);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));


        //then
        Assertions.assertThat(strikeCount).isEqualTo(1);
        Assertions.assertThat(ballCount).isEqualTo(0);
    }

    @Test
    @DisplayName("투스트라이크 검증")
    public void 투스트라이크_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 125
        playerNumbers = Arrays.asList(1,2,5);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(2);
        Assertions.assertThat(ballCount).isEqualTo(0);
    }

    @Test
    @DisplayName("쓰리스트라이크 검증")
    public void 쓰리스트라이크_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 425
        playerNumbers = Arrays.asList(4,2,5);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(3);
        Assertions.assertThat(ballCount).isEqualTo(0);
    }


    @Test
    @DisplayName("원볼 원스트라이크 검증")
    public void 원볼_원스트라이크_테스트(){
        //given
        //상대방(컴퓨터)의 수가 425
        computerNumbers = Arrays.asList(4,2,5);
        //플레이어의 입력 값이 542
        playerNumbers = Arrays.asList(4,5,6);

        //when
        setCount(baseBallRule.countStrike(computerNumbers, playerNumbers), baseBallRule.countBall(computerNumbers, playerNumbers));

        //then
        Assertions.assertThat(strikeCount).isEqualTo(1);
        Assertions.assertThat(ballCount).isEqualTo(1);

    }
}