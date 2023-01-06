package gmbs.view;

import gmbs.common.Constant;
import gmbs.game.BaseballRuleChecker;

public class OutputView {

    private final int strikeCount;
    private final int ballCount;

    public OutputView(BaseballRuleChecker baseballRuleChecker) {
        strikeCount = baseballRuleChecker.getStrikeCount();
        ballCount = baseballRuleChecker.getBallCount();
    }

    public void printResult() {
        printOnlyStrike();
        printOnlyBall();
        printStrikeAndBall();
        printNothing();
    }

    private void printNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    private void printStrikeAndBall() {
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
        }
    }

    private void printOnlyBall() {
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
    }

    private void printOnlyStrike() {
        if (strikeCount == Constant.MAX_STRIKE_COUNT) {
            System.out.println(Constant.MAX_STRIKE_COUNT + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + " 스트라이크");
        }
    }
}
