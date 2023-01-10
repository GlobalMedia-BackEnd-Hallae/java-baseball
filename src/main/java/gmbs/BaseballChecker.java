package gmbs;

import java.util.List;

public class BaseballChecker {
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
}
