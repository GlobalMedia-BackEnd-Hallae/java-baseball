package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();
    @ParameterizedTest
    @DisplayName("주어진 길이에 맞는 각 자리수가 서로 다른 자연수인지 확인한다")
    @CsvSource(value = {"111, 3, false", "1, 1, true", "123, 4, false", "123, 3, true", "0, 1, false", "120, 3, false"})
    void isValidNumberInput(String input, int length, boolean expect) {
        boolean actual = validator.isValidNumberInput(input, length);
        assertThat(actual).isEqualTo(expect);
    }
}
