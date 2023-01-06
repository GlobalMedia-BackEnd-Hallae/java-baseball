package gmbs.util;

import gmbs.common.Constant;

import java.util.*;

public class RandomNumberGenerator {

    private static final int UNITS = 0;

    public List<Integer> generate() {
        return getNonDuplicateRandomNumber();
    }

    private List<Integer> getNonDuplicateRandomNumber() {
        Set<Integer> nonDuplicateSet = new HashSet<>(Constant.MAX_INPUT_SIZE);

        while (nonDuplicateSet.size() < Constant.MAX_INPUT_SIZE) {
            int random = (int) (Math.random() * 10);
            nonDuplicateSet.add(random);
        }

        return shuffleRandomNumber(nonDuplicateSet);
    }

    private List<Integer> shuffleRandomNumber(Set<Integer> nonDuplicateSet) {
        List<Integer> randomNumber = new ArrayList<>(nonDuplicateSet);
        do {
            Collections.shuffle(randomNumber);
        } while (randomNumber.get(UNITS).equals(0));
        return randomNumber;
    }
}
