package gmbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void RandomTest() {
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> test = randomNumber.create();
        assertThat(3).isEqualTo(test.size());
    }
}
