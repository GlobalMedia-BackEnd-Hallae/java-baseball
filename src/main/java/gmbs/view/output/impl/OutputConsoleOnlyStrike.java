package gmbs.view.output.impl;

import gmbs.view.output.OutputConsole;

public class OutputConsoleOnlyStrike implements OutputConsole {

    private final int strike;

    public OutputConsoleOnlyStrike(final int strike) {
        this.strike = strike;
    }

    @Override
    public void printResult() {
        System.out.println(strike + "스트라이크");
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
