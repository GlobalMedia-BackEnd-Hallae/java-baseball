package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    private final UserInput userInput = new UserInput();

    @ParameterizedTest
    @DisplayName("입력값이 자연수인지 확인한다")
    @CsvSource(value = {"123, true", "123.4, false", "123f, false", "-123, false", "abc, false", "0, false"})
    void isNaturalNumber(String input, boolean expect) {
        boolean actual = userInput.isNaturalNumber(input);
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("입력값에 중복이 있는지 확인한다")
    @CsvSource(value = {"1123, false", "asdf, true", "13a3, false", "31, true"})
    void hasNoOverlap(String input, boolean expect) {
        boolean actual = userInput.hasNoOverlap(input);
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("주어진 길이에 맞는 각 자리수가 서로 다른 자연수인지 확인한다")
    @CsvSource(value = {"111, 3, false", "1, 1, true", "123, 4, false", "123, 3, true", "0, 1, false"})
    void isValidNumberInput(String input, int length, boolean expect) {
        boolean actual = userInput.isValidNumberInput(input, length);
        assertThat(actual).isEqualTo(expect);
    }
}