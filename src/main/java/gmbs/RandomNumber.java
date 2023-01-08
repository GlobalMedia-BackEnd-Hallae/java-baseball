package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;

    private int MakeRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + MIN_NUMBER;
    }

    List<Integer> create() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = MakeRandomNumber();
            if (computerNumber.contains(randomNumber)) {
                continue;
            } else {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println(computerNumber);
        return computerNumber;
    }
}
