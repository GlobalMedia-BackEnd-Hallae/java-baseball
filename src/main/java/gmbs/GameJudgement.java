package gmbs;

import java.util.List;

public class GameJudgement {
    Compare compare = new Compare();
    public String judgement(List<Integer> computer, List<Integer> player){
        int total = compare.Count(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = total - strike;

        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}