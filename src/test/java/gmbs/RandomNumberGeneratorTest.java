package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberGeneratorTest {
    RandomNumberGenerator random = new RandomNumberGenerator();

    @ParameterizedTest
    @DisplayName("입력된 길이만큼 중복없는 숫자들을 반환한다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getRandomNumbers(int length) {
        //given
        int testLength = length;
        //when
        HashSet<Integer> randomNumbers = new HashSet<>(random.getRandomNumbers(testLength));
        //then
        assertThat(randomNumbers).hasSize(testLength);
    }

    @Test
    @DisplayName("한자리 자연수를 반환한다")
    void getRandomDigit() {
        //given
        int testCount = 1000;
        HashSet<Integer> randomNumbers = new HashSet<>();
        HashSet<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        //when
        for (int i = 0; i < testCount; i++) {
            randomNumbers.add(random.getRandomDigit());
        }
        //then
        assertThat(randomNumbers).isEqualTo(expected);
    }
}