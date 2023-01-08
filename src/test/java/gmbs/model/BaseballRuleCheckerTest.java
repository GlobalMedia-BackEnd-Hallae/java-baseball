package gmbs.model;

import gmbs.model.dto.BallCountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballRuleCheckerTest {

    private static final List<Integer> COMPUTER_BALL = List.of(1, 2, 3);
    private static final List<Integer> INPUT_NOTHING = List.of(7, 8, 9);
    private static final List<Integer> INPUT_ONLY_STRIKE = List.of(1, 8, 9);
    private static final List<Integer> INPUT_ONLY_BALL = List.of(7, 3, 9);
    private static final List<Integer> INPUT_STRIKE_AND_BALL = List.of(1, 3, 5);
    private static final List<Integer> INPUT_ALL_STRIKE = List.of(1, 2, 3);

    @DisplayName("컴퓨터 생성 랜덤 숫자와 입력 숫자를 받아 strike, ball 카운트를 얻는다")
    @ParameterizedTest
    @MethodSource("setBaseballGameAndExpect")
    void getBallCount(List<Integer> computerNumber, List<Integer> inputNumber, int strikeExpect, int ballExpect) {
        BaseballRuleChecker ruleChecker = new BaseballRuleChecker(computerNumber);
        BallCountDto ballCount = ruleChecker.getBallCount(inputNumber);

        assertAll(
                () -> assertThat(ballCount.getStrike()).isEqualTo(strikeExpect),
                () -> assertThat(ballCount.getBall()).isEqualTo(ballExpect)
        );
    }

    private static Stream<Arguments> setBaseballGameAndExpect() {
        return Stream.of(
                Arguments.of(COMPUTER_BALL, INPUT_NOTHING, 0 , 0),
                Arguments.of(COMPUTER_BALL, INPUT_ONLY_STRIKE, 1 , 0),
                Arguments.of(COMPUTER_BALL, INPUT_ONLY_BALL, 0 , 1),
                Arguments.of(COMPUTER_BALL, INPUT_STRIKE_AND_BALL, 1 , 1)
        );
    }

    @DisplayName("컴퓨터 생성 랜덤 숫자와 입력 숫자를 받아 게임 종료 요건을 얻는다")
    @ParameterizedTest
    @MethodSource("setAllStrikeBaseballGameAndExpect")
    void get(List<Integer> computerNumber, List<Integer> inputNumber, boolean expect) {
        BaseballRuleChecker ruleChecker = new BaseballRuleChecker(computerNumber);
        BallCountDto ballCount = ruleChecker.getBallCount(inputNumber);
        assertThat(ballCount.isMaxStrike()).isEqualTo(expect);
    }

    private static Stream<Arguments> setAllStrikeBaseballGameAndExpect() {
        return Stream.of(
                Arguments.of(COMPUTER_BALL, INPUT_ALL_STRIKE, true),
                Arguments.of(COMPUTER_BALL, INPUT_NOTHING, false)
        );
    }
}