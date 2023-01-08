package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {
    Compare compare = new Compare();

    @Test
    @DisplayName("테스트 해보기")
    void canCompare() {
        // given
        String userNumber = "123";
        String randomNumber = "124";

        // when
        String result = compare.checkResult(randomNumber, userNumber);

        // then
        assertThat(result).isEqualTo("02");
    }
}