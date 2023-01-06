package gmbs.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("일의자리가_0이_아닌_중복없는_세자리_수가_생성된다")
    @Test
    void generate() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // when
        List<Integer> randomNumberList = generator.generate();

        // then
        List<Integer> nonDuplicateList = randomNumberList.stream()
                .distinct()
                .collect(Collectors.toList());

        assertAll(
                () -> assertThat(nonDuplicateList.get(0)).isNotEqualTo(0),
                () -> assertThat(nonDuplicateList.size()).isEqualTo(3)
        );
    }
}