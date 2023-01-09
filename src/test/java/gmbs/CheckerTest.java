package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckerTest {
    private Checker checker = new Checker();

    @Test
    @DisplayName("잘못된 문자열 입력 후 오류나는지 테스트")
    void canCheck() {
        // given
        String longerInput = "123456789ad";
        String shorterInput = "12";
        String notNumberInput = "1ab";
        String overlapInput = "122";

        // when

        // then
        assertThatThrownBy(() -> checker.checkNumber(longerInput))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> checker.checkNumber(shorterInput))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> checker.checkNumber(notNumberInput))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> checker.checkNumber(overlapInput))
                .isInstanceOf(IllegalStateException.class);
    }
}