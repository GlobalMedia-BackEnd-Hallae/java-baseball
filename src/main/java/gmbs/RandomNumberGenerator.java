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
        int tempRandomDigit;
        for (int i = 0; i < length; i++) {
            do {
                tempRandomDigit = getRandomDigit();
            } while (tempNumbers.contains(tempRandomDigit));
            tempNumbers.add(tempRandomDigit);
        }
        return tempNumbers;
    }
}
