package gmbs;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
    private final Random random = new Random();

    public int getRandomDigit() {
        return random.nextInt(9) + 1;
    }

    public ArrayList<Integer> getRandomNumbers(int length) {
        ArrayList<Integer> tempNumbers = new ArrayList<>();
        int randomDigit;
        for (int i = 0; i < length; i++) {
            do {
                randomDigit = getRandomDigit();
            } while (tempNumbers.contains(randomDigit));
            tempNumbers.add(randomDigit);
        }
        return tempNumbers;
    }
}
