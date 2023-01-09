package gmbs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameJudgementTest {
    Compare compare;
    GameJudgement gameJudgement;

    @BeforeEach
    void SetUp() {
        compare = new Compare();
        gameJudgement = new GameJudgement();
    }

    @Test
    @DisplayName("3볼 테스트")
    void ball() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(3, 1, 2);
        String result = "3볼";

        assertThat(gameJudgement.GameJudgement(computer, player))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void StrikeCheck() {
        List<Integer> computer = List.of(4, 5, 6);
        List<Integer> player = List.of(4, 5, 6);
        String result = "3스트라이크";

        assertThat(gameJudgement.GameJudgement(computer, player))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void IndexCheck() {
        List<Integer> computer = List.of(7, 8, 9);
        List<Integer> player = List.of(7, 9, 8);
        String result = "2볼 1스트라이크";

        assertThat(gameJudgement.GameJudgement(computer, player))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("낫싱테스트")
    void NothingCheck() {
        List<Integer> computer = List.of(4, 5, 6);
        List<Integer> player = List.of(7, 9, 8);
        String result = "낫싱";

        assertThat(gameJudgement.GameJudgement(computer, player))
                .isEqualTo(result);
    }
}
