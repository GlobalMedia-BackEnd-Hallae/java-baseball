package gmbs.view.output.impl;

import gmbs.view.output.OutputConsole;

public class OutputConsoleStrikeAndBall implements OutputConsole {

    private final int strike;
    private final int ball;

    public OutputConsoleStrikeAndBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public void printResult() {
        System.out.println(strike + "스트라이크," + ball + "볼");
    }
}
