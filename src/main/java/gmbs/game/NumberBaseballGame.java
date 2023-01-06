package gmbs.game;

import gmbs.util.RandomNumberGenerator;
import gmbs.view.InputView;
import gmbs.view.OutputView;

import java.util.List;

public class NumberBaseballGame {

    private static final String RESTART = "1";
    private static final String FINISH = "2";

    public void play() {
        do {
            startGame();
        } while (!isGameEnd());
    }

    private void startGame() {
        BaseballRuleChecker baseballRuleChecker;
        OutputView outputView;

        List<Integer> randomNumberList =  new RandomNumberGenerator().generate();

        do {
            List<Integer> inputNumberList = InputView.readInputNumber();

            baseballRuleChecker = new BaseballRuleChecker(randomNumberList, inputNumberList);
            outputView = new OutputView(baseballRuleChecker);
            outputView.printResult();
        } while (!baseballRuleChecker.isMaxStrikeCount());
    }

    private boolean isGameEnd() {
        return switch (InputView.readEnd()) {
            case RESTART -> false;
            case FINISH -> true;
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
