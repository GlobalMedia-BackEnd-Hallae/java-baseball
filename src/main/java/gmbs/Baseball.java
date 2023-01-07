package gmbs;

import java.util.ArrayList;

public class Baseball {
    private final ArrayList<Integer> inputNumbers = new ArrayList<>();
    private final ArrayList<Integer> randomNumbers = new ArrayList<>();
    private final UserInput userInput = new UserInput();
    private final RandomNumberGenerator random = new RandomNumberGenerator();
    private int strikes;
    private int balls;

    Baseball() {
        for (int i = 0; i < Constant.inputLength; i++) {
            inputNumbers.add(null);
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void addStrikes() {
        strikes++;
    }

    public void addBalls() {
        balls++;
    }

    public void resetStrikes() {
        strikes = 0;
    }

    public void resetBalls() {
        balls = 0;
    }


    public void setRandomNumbers() {
        randomNumbers.addAll(random.getRandomNumbers(3));
    }

    public void showRandomNumbers() {
        for (int i = 0; i < Constant.inputLength; i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public void setInputNumbers() {
        int dividend;
        dividend = userInput.getNumber();
        for (int i = Constant.inputLength - 1; i >= 0; i--) {
            inputNumbers.set(i, dividend % 10);
            dividend /= 10;
        }
    }

    private void check() {
        for (int i = 0; i < Constant.inputLength; i++) {
            if (inputNumbers.get(i).equals(randomNumbers.get(i))) {
                addStrikes();
            } else if (randomNumbers.contains(inputNumbers.get(i))) {
                addBalls();
            }
        }
    }

    private void resetAll() {
        for (int i = 0; i < Constant.inputLength; i++) {
            inputNumbers.set(i, null);
        }
        randomNumbers.clear();
        resetStrikes();
        resetBalls();
    }

    public void resetCounts() {
        resetStrikes();
        resetBalls();
    }

    public void playOneGame() {
        resetAll();
        setRandomNumbers();
        showRandomNumbers();
        while (strikes < Constant.MAX_STRIKES) {
            resetCounts();
            setInputNumbers();
            check();
            Display.countsDisplay(getStrikes(), getBalls());
        }
    }

    public void playBall() {
        do {
            playOneGame();
        } while (userInput.getYesNo());
    }
}
