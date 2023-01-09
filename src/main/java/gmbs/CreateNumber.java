package gmbs;

import java.util.Random;

public class CreateNumber {
    private Random random = new Random();
    private Checker checker = new Checker();

    private String randomNumber() {
        StringBuilder temporaryNumber = new StringBuilder();

        for (int index = 0; index < Constant.NUMBER_LENGTH; index++) {
            temporaryNumber.append((random.nextInt(Constant.NUMBER_RANGE) + 1));
        }

        return temporaryNumber.toString();
    }

    public String createRandomNumber() {
        try {
            String createdNumber = randomNumber();
            checker.checkNumber(createdNumber);
            return createdNumber;
        } catch (IllegalStateException error) {
            return createRandomNumber();
        }
    }
}
