package gmbs;

import java.util.Random;

public class Create {
    private Random random = new Random();

    private String randomNumber() {
        StringBuilder temporaryNumber = new StringBuilder();

        for (int index = 0; index < Constant.NUMBER_LENGTH; index++) {
            temporaryNumber.append(Integer.toString((random.nextInt(Constant.NUMBER_RANGE) + 1)));
        }

        return temporaryNumber.toString();
    }

    public String createRandomNumber() {
        String createdNumber;

        try {
            createdNumber = randomNumber();
            Checker checker = new Checker();
            checker.checkNumber(createdNumber);
            return createdNumber;
        } catch (IllegalStateException error) {
            return createRandomNumber();
        }
    }
}
