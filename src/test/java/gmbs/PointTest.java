package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    Point point = new Point();

    @Test
    @DisplayName("테스트 해보기")
    void canPoint() {
        // given
        int result = Constant.BALL;

        // when
        int ballResult = point.checkBall(result);
        int strikeResult = point.checkStrike(result);

        // then
        assertThat(ballResult).isEqualTo(1);
        assertThat(strikeResult).isZero();
    }
}