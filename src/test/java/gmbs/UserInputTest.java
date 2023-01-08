package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    private final UserInput userInput = new UserInput();

    @ParameterizedTest
    @DisplayName("입력값이 정수인지 확인한다")
    @CsvSource(value = {"123, true", "123.4, false", "123f, false", "-123, true", "abc, false", "0, true"})
    void isInt(String input, boolean expect) {
        boolean actual = userInput.isInt(input);
        assertThat(actual).isEqualTo(expect);
    }
}