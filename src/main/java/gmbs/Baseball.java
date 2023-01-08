package gmbs;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final ArrayList<Integer> inputNumbers = new ArrayList<>();
    private final ArrayList<Integer> randomNumbers = new ArrayList<>();
    private final UserInput userInput = new UserInput();
    private final RandomNumberGenerator random = new RandomNumberGenerator();

    public void setRandomNumbers() {
        randomNumbers.addAll(random.getRandomNumbers(3));
    }

    public void showRandomNumbers() {
        for (int i = 0; i < Constant.inputLength; i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public void setInputNumbers() {
        Display.showNumberInputDisplay(Constant.inputLength);
        if (!inputNumbers.isEmpty()) {
            inputNumbers.clear();
        }
        inputNumbers.addAll(userInput.getNumbers());
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

    private void resetAll() {
        inputNumbers.clear();
        randomNumbers.clear();
    }

    public void playOneGame() {
        int strikes;
        int balls;
        resetAll();
        setRandomNumbers();
        showRandomNumbers();
        do {
            setInputNumbers();
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
