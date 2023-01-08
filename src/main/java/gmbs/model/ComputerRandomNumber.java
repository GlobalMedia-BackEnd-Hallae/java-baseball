package gmbs.model;

import gmbs.common.Constant;
import gmbs.util.RandomNumber;

import java.util.*;

public class ComputerRandomNumber {

    private final RandomNumber randomNumber = new RandomNumber();

    public List<Integer> generate() {
        Set<Integer> randomBall = new LinkedHashSet<>();
        while (randomBall.size() < Constant.MAX_BALL_COUNT) {
            randomBall.add(randomNumber.generate());
        }
        return new ArrayList<>(randomBall);
    }
}
