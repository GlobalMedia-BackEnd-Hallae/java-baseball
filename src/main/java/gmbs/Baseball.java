package gmbs;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final UserInput userInput = new UserInput();
    private final RandomNumberGenerator random = new RandomNumberGenerator();
    private final Display display = new Display();
    private final BaseballChecker checker = new BaseballChecker();

    private boolean isStrikeOut(int strikeCount) {
        return strikeCount == Constant.INPUT_LENGTH;
    }

    private void playOneGame() {
        int strikes;
        int balls;
        List<Integer> randomNumbers = new ArrayList<>(random.getRandomNumbers(Constant.INPUT_LENGTH));
        do {
            List<Integer> inputNumbers = new ArrayList<>(userInput.getNumbers());
            strikes = checker.strikeCount(randomNumbers, inputNumbers);
            balls = checker.ballCount(randomNumbers, inputNumbers);
            display.showStrikeBallCounts(strikes, balls);
        } while (!isStrikeOut(strikes));
    }

    public void playBall() {
        do {
            playOneGame();
        } while (userInput.checkReplay());
    }
}
