package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {
    private Compare compare = new Compare();

    @Test
    @DisplayName("수를 제대로 비교하는지 테스트")
    void canCompare() {
        // given
        String userNumber1 = "465";
        String randomNumber1 = "456";
        String userNumber2 = "123";
        String randomNumber2 = "456";
        String userNumber3 = "123";
        String randomNumber3 = "124";
        String userNumber4 = "123";
        String randomNumber4 = "123";
        String userNumber5 = "123";
        String randomNumber5 = "312";

        // when
        String result1 = compare.checkResult(randomNumber1, userNumber1);
        String result2 = compare.checkResult(randomNumber2, userNumber2);
        String result3 = compare.checkResult(randomNumber3, userNumber3);
        String result4 = compare.checkResult(randomNumber4, userNumber4);
        String result5 = compare.checkResult(randomNumber5, userNumber5);

        // then
        assertThat(result1).isEqualTo("21");
        assertThat(result2).isEqualTo("00");
        assertThat(result3).isEqualTo("02");
        assertThat(result4).isEqualTo("03");
        assertThat(result5).isEqualTo("30");
    }
}