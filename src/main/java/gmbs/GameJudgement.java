package gmbs;

import java.util.List;

public class GameJudgement {
    Compare compare = new Compare();
    public String GameJudgement(List<Integer> computer, List<Integer> player) {
        int IndexCheck = compare.Count(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = IndexCheck - strike;

        if (IndexCheck == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
