package gmbs.model;

import gmbs.model.dto.BallCountDto;

import java.util.List;
import java.util.stream.IntStream;

import static gmbs.common.Constant.*;

public class BaseballRuleChecker {

    private static final int START_INDEX = 0;

    private final List<Integer> computerRandomBall;

    public BaseballRuleChecker(final List<Integer> computerRandomBall) {
        this.computerRandomBall = computerRandomBall;
    }

    public BallCountDto getBallCount(List<Integer> inputRandomBall) {
        return new BallCountDto(getStrike(inputRandomBall), getBall(inputRandomBall));
    }

    private int getStrike(List<Integer> inputRandomBall) {
        return (int) IntStream.range(START_INDEX, MAX_BALL_COUNT)
                .filter(index -> isSameValueAtSameIndex(index, inputRandomBall))
                .count();
    }

    private int getBall(List<Integer> inputRandomBall) {
        return (int) IntStream.range(START_INDEX, MAX_BALL_COUNT)
                .filter(index -> hasValueAtNotSameIndex(inputRandomBall, index))
                .count();
    }

    private boolean hasValueAtNotSameIndex(List<Integer> inputRandomBall, int index) {
        return !isSameValueAtSameIndex(index, inputRandomBall)
                && computerRandomBall.contains(inputRandomBall.get(index));
    }

    private boolean isSameValueAtSameIndex(int index, List<Integer> inputRandomBall) {
        return computerRandomBall.get(index)
                .equals(inputRandomBall.get(index));
    }
}
