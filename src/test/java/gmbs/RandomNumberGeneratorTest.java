package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberGeneratorTest {
    RandomNumberGenerator random = new RandomNumberGenerator();

    @ParameterizedTest
    @DisplayName("입력된 길이만큼 중복없는 숫자들을 반환한다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getRandomNumbers(int length) {
        HashSet<Integer> randomNumbers = new HashSet<>(random.getRandomNumbers(length));
        assertThat(randomNumbers).hasSize(length);
    }

    @Test
    @DisplayName("한자리 자연수를 반환한다")
    void getRandomDigit() {
        assertThat(random.getRandomDigit()).isBetween(1, 9);
    }
}