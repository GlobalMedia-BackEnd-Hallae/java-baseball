package gmbs.game;

import gmbs.util.RandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class NumberBaseballGameTest {

    private static RandomNumberGenerator randomNumberGenerator;

    @ParameterizedTest
    @MethodSource({"generateRandom"})
    void play(List<Integer> randomNumber, List<Integer> inputNumber) {

    }

    private static List<Integer> generateRandom() {
        return randomNumberGenerator.generate();
    }
}