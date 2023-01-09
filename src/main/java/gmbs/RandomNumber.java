package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private static final int MINIMUN_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MAXIMUM_COMPUTER_NUMBER = 3;

    private int MakeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_NUMBER) + MINIMUN_NUMBER;
    }

    public List<Integer> create() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < MAXIMUM_COMPUTER_NUMBER) {
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
