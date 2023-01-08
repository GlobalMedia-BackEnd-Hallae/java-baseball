package gmbs.view.output.impl;

import gmbs.view.output.OutputConsole;

public class OutputConsoleOnlyBall implements OutputConsole {

    private final int ball;

    public OutputConsoleOnlyBall(final int ball) {
        this.ball = ball;
    }

    @Override
    public void printResult() {
        System.out.println(ball + "볼");
    }
}
