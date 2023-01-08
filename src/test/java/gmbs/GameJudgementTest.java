package gmbs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameJudgementTest {
    Compare compare;
    GameJudgement gameJudgement;

    @BeforeEach
    void SetUp() {
        compare = new Compare();
        gameJudgement = new GameJudgement();
    }

    @Test
    @DisplayName("3볼 테스트")
    void BallCheck() {
        assertThat("3볼").isEqualTo(gameJudgement.GameJudgement(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2)));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void StrikeCheck() {
        assertThat("3스트라이크").isEqualTo(gameJudgement.GameJudgement(Arrays.asList(4, 5, 6), Arrays.asList(4, 5, 6)));
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void IndexCheck() {
        assertThat("2볼 1스트라이크").isEqualTo(gameJudgement.GameJudgement(Arrays.asList(7, 8, 9), Arrays.asList(7, 9, 8)));
    }


    @Test
    @DisplayName("낫싱테스트")
    void NothingCheck() {
        assertThat("낫싱").isEqualTo(gameJudgement.GameJudgement(Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)));
    }
}
