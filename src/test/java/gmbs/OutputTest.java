package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {
    private Output output = new Output();

    @Test
    @DisplayName("볼, 스트라이크 개수에 따라서 결과가 잘 출력되고 CONTINUE와 END가 알맞게 설정되는지 확인")
    void canOutput() {
        // given
        String zeroBallZeroStrike = "00";
        String oneBalloneStrike = "11";
        String threeStrike = "03";

        // when
        int resultOfContinue1 = output.output(zeroBallZeroStrike);
        int resultOfContinue2 = output.output(oneBalloneStrike);
        int resultOfEnd = output.output(threeStrike);

        // then
        assertThat(resultOfContinue1).isEqualTo(1);
        assertThat(resultOfContinue2).isEqualTo(1);
        assertThat(resultOfEnd).isEqualTo(2);
    }
}