package gmbs.view.output;

import gmbs.model.dto.BallCountDto;
import gmbs.view.output.impl.OutputConsoleNothing;
import gmbs.view.output.impl.OutputConsoleOnlyBall;
import gmbs.view.output.impl.OutputConsoleOnlyStrike;
import gmbs.view.output.impl.OutputConsoleStrikeAndBall;

public interface OutputConsole {

    default void printResult() {
        System.out.println("결과입니다");
    };

    default OutputConsole checkTypeByBallCount(BallCountDto ballCount) {
        OutputConsole outputConsole = null;

        if (ballCount.isNothing()) {
            outputConsole = new OutputConsoleNothing();
        } else if (ballCount.isOnlyBall()) {
            outputConsole = new OutputConsoleOnlyBall(ballCount.getBall());
        } else if (ballCount.isOnlyStrike()) {
            outputConsole = new OutputConsoleOnlyStrike(ballCount.getStrike());
        } else if (ballCount.isStrikeAndBall()) {
            outputConsole = new OutputConsoleStrikeAndBall(ballCount.getStrike(), ballCount.getBall());
        }

        return outputConsole;
    }
}
