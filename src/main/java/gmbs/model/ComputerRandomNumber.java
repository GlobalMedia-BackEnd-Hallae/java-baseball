package gmbs.model;

import gmbs.util.RandomNumber;

import java.util.*;

public class ComputerRandomNumber {

    private static final int MAX_BALL = 3;

    private final RandomNumber randomNumber = new RandomNumber();

    public List<Integer> generate() {
        Set<Integer> randomBall = new LinkedHashSet<>();
        while (randomBall.size() < MAX_BALL) {
            randomBall.add(randomNumber.generate());
        }
        return new ArrayList<>(randomBall);
    }
}
