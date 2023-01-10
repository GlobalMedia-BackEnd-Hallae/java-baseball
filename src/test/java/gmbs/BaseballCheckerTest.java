package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class BaseballCheckerTest {
    BaseballChecker checker = new BaseballChecker();

    @ParameterizedTest
    @DisplayName("두 리스트에서 인덱스와 값이 모두 일치하는 요소의 개수를 반환한다")
    @MethodSource("generateStrikeData")
    void strikeCount(List<Integer> firstList, List<Integer> secondList, int expected) {
        assertThat(checker.strikeCount(firstList, secondList)).isEqualTo(expected);
    }

    static Stream<Arguments> generateStrikeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3),
                Arguments.of(Arrays.asList(3, 2, 2), Arrays.asList(5, 1, 2), 1),
                Arguments.of(Arrays.asList(1, 2, 1, 5, 6), Arrays.asList(2, 3, 4, 7, 8), 0),
                Arguments.of(Arrays.asList(3, 2, 3, 4, 5), Arrays.asList(2, 2, 2), 1)
        );
    }

    @ParameterizedTest
    @DisplayName("오른쪽 리스트에서 두 리스트의 교집합 중 인덱스가 다른 요소의 수를 반환한다")
    @MethodSource("generateBallData")
    void ballCount(List<Integer> firstList, List<Integer> secondList, int expected) {
        assertThat(checker.ballCount(firstList, secondList)).isEqualTo(expected);
    }

    static Stream<Arguments> generateBallData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 0),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2), 3),
                Arguments.of(Arrays.asList(3, 3, 1, 1, 1), Arrays.asList(1, 2), 1),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 2)
        );
    }
}