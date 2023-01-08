package gmbs;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final UserInput userInput = new UserInput();
    private final RandomNumberGenerator random = new RandomNumberGenerator();
    private final Display display = new Display();

    public int strikeCount(List<Integer> randomNumbers, List<Integer> userInput) {
        int strikeCount = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(randomNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int ballCount(List<Integer> randomNumbers, List<Integer> userInput) {
        int ballCount = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (randomNumbers.contains(userInput.get(i)) && !userInput.get(i).equals(randomNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isStrikeOut(int strikeCount) {
        return strikeCount == Constant.INPUT_LENGTH;
    }

    private void playOneGame() {
        int strikes;
        int balls;
        List<Integer> randomNumbers = new ArrayList<>(random.getRandomNumbers(Constant.INPUT_LENGTH));
        do {
            List<Integer> inputNumbers = new ArrayList<>(userInput.getNumbers());
            strikes = strikeCount(randomNumbers, inputNumbers);
            balls = ballCount(randomNumbers, inputNumbers);
            display.showStrikeBallCounts(strikes, balls);
        } while (!isStrikeOut(strikes));
    }

    public void playBall() {
        do {
            playOneGame();
        } while (userInput.checkReplay());
    }
}
