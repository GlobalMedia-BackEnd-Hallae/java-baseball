package gmbs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {
    Compare compare;

    @BeforeEach
    void setUp() {
        compare = new Compare();
    }

    @Test
    @DisplayName("숫자확인 테스트")
    void count() {
        assertThat(3).isEqualTo(compare.Count(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2)));
    }

    @Test
    @DisplayName("스트라이크 수 테스트")
    void strike() {
        assertThat(1).isEqualTo(compare.countStrike(Arrays.asList(4, 5, 6), Arrays.asList(6, 5, 4)));
    }
}
