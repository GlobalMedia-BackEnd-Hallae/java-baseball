package gmbs.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @DisplayName("1~9 사이의 랜덤 숫자를 생성한다")
    @Test
    void generate() {
        RandomNumber randomNumber = new RandomNumber();
        int actual = randomNumber.generate();
        assertThat(actual).isBetween(1, 9);
    }
}