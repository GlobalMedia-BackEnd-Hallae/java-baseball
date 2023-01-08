package gmbs;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final UserInput userInput = new UserInput();
    private final RandomNumberGenerator random = new RandomNumberGenerator();

    public void showRandomNumbers(List<Integer> randomNumbers) {
        System.out.println(randomNumbers);
    }

    public int strikeCount(List<Integer> randomNumbers, List<Integer> userInput) {
        int strikeCount = 0;
        for (int i = 0; i < Constant.inputLength; i++) {
            if (userInput.get(i).equals(randomNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int ballCount(List<Integer> randomNumbers, List<Integer> userInput) {
        int ballCount = 0;
        for (int i = 0; i < Constant.inputLength; i++) {
            if (randomNumbers.contains(userInput.get(i)) && !userInput.get(i).equals(randomNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean isStrikeOut(int strikeCount) {
        return strikeCount == Constant.inputLength;
    }

    public void playOneGame() {
        int strikes;
        int balls;
        List<Integer> randomNumbers = new ArrayList<>(random.getRandomNumbers(Constant.inputLength));
        showRandomNumbers(randomNumbers);
        do {
            List<Integer> inputNumbers = new ArrayList<>(userInput.getNumbers());
            strikes = strikeCount(randomNumbers, inputNumbers);
            balls = ballCount(randomNumbers, inputNumbers);
            Display.showStrikeBallCounts(strikes, balls);
        } while (!isStrikeOut(strikes));
    }

    public void playBall() {
        do {
            playOneGame();
        } while (userInput.getYesNo());
    }
}
