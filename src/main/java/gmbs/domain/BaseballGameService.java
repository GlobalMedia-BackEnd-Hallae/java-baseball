package gmbs.domain;

import gmbs.common.Constant;
import gmbs.model.BaseballRuleChecker;
import gmbs.model.ComputerRandomNumber;
import gmbs.model.dto.BallCountDto;
import gmbs.view.input.InputConsole;
import gmbs.view.output.OutputConsole;
import gmbs.view.output.OutputConsoles;

import java.util.List;

public class BaseballGameService {

    private final InputConsole inputConsole;
    private final BaseballRuleChecker ruleChecker;
    private BallCountDto ballCount;

    public BaseballGameService(final InputConsole inputConsole) {
        this.inputConsole = inputConsole;
        List<Integer> computerRandomNumber = new ComputerRandomNumber().generate();
        System.out.println(computerRandomNumber);
        this.ruleChecker = new BaseballRuleChecker(computerRandomNumber);
    }

    public void play() {
        do {
            startGame();
        } while (!ballCount.isMaxStrike());
    }

    private void startGame() {
        List<Integer> inputRandomNumber = inputConsole.readInput();
        ballCount = ruleChecker.getBallCount(inputRandomNumber);
        OutputConsole outputConsole = new OutputConsoles().checkTypeByBallCount(ballCount);
        outputConsole.printResult();
    }

    public boolean gameRestart() {
        return inputConsole.readEnd().equals(Constant.RESTART);
    }
}
