package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    private Point point = new Point();

    @Test
    @DisplayName("볼, 스트라이크, 낫싱 여부 테스트")
    void canPoint() {
        // given
        int ball = Constant.BALL;
        int strike = Constant.STRIKE;
        int notExist = Constant.NOT_EXIST;

        // when
        boolean ballResultOfCheckBall = point.checkBall(ball);
        boolean ballResultOfCheckStrike = point.checkStrike(ball);
        boolean strikeResultOfCheckBall = point.checkBall(strike);
        boolean strikeResultOfCheckStrike = point.checkStrike(strike);
        boolean nothingResultOfCheckBall = point.checkBall(notExist);
        boolean nothingResultOfCheckStrike = point.checkStrike(notExist);

        // then
        assertThat(ballResultOfCheckBall).isTrue();
        assertThat(ballResultOfCheckStrike).isFalse();
        assertThat(strikeResultOfCheckBall).isFalse();
        assertThat(strikeResultOfCheckStrike).isTrue();
        assertThat(nothingResultOfCheckBall).isFalse();
        assertThat(nothingResultOfCheckStrike).isTrue();
    }
}