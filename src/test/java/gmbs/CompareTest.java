package gmbs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {
    Compare compare;

    @BeforeEach
    void setUp() {
        compare = new Compare();
    }

    @Test
    @DisplayName("숫자 3개를 가진 리스트를 두 개 입력받아서 서로 같은 숫자가 몇 개 있는지 확인한다")
    void count() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 2, 3);
        int result = 3;

        assertThat(compare.Count(computer, player))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("숫자 3개를 가진 리스트를 두 개 입력받아서 몇 개의 스트라이크가 있는지 확인한다")
    void strike() {
        List<Integer> computer = List.of(4, 5, 6);
        List<Integer> player = List.of(6, 5, 4);
        int result = 1;

        assertThat(compare.countStrike(computer, player))
                .isEqualTo(result);
    }
}
