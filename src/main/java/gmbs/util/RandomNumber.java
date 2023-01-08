package gmbs.util;

import java.util.*;

public class RandomNumber {

    private static final int START = 1;
    private static final int END = 9;

    public int generate() {
        return START + new Random().nextInt(END);
    }
}
