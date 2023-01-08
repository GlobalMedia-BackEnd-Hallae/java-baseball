package gmbs.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerRandomNumberTest {

    private static final int MAX_BALL_COUNT = 3;

    @DisplayName("중복 없는 세자리 랜덤 숫자를 생성한다")
    @Test
    void generate() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> generate = computerRandomNumber.generate();

        List<Integer> actual = generate.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(actual.size()).isEqualTo(MAX_BALL_COUNT);
        for (Integer random : actual) {
            assertThat(random).isBetween(1, 9);
        }
    }
}