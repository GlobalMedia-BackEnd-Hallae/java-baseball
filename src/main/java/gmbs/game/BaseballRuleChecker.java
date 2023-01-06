package gmbs.game;

import gmbs.common.Constant;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class BaseballRuleChecker {

    private static final int START_INDEX = 0;

    private final int strikeCount;
    private final int ballCount;

    public BaseballRuleChecker(List<Integer> randomNumberList, List<Integer> inputNumberList) {
        this.strikeCount = setStrikeCount(randomNumberList, inputNumberList);
        this.ballCount = setBallCount(randomNumberList, inputNumberList);
    }

    private int setStrikeCount(List<Integer> randomNumberList, List<Integer> inputNumberList) {
         return (int) Stream.iterate(START_INDEX, increaseOneOperator()).limit(Constant.MAX_INPUT_SIZE)
                .filter(index -> isSameValueAtSameIndex(randomNumberList, inputNumberList, index))
                .count();
    }

    private int setBallCount(List<Integer> randomNumberList, List<Integer> inputNumberList) {
        return (int) Stream.iterate(START_INDEX, increaseOneOperator()).limit(Constant.MAX_INPUT_SIZE)
                .filter(index ->
                        !isSameValueAtSameIndex(randomNumberList, inputNumberList, index)
                        && isContainValue(randomNumberList, inputNumberList, index))
                .count();
    }

    private UnaryOperator<Integer> increaseOneOperator() {
        return index -> index + 1;
    }

    private boolean isSameValueAtSameIndex(List<Integer> randomNumberList, List<Integer> inputNumberList, Integer index) {
        return randomNumberList.get(index).equals(inputNumberList.get(index));
    }

    private boolean isContainValue(List<Integer> randomNumberList, List<Integer> inputNumberList, Integer index) {
        return randomNumberList.contains(inputNumberList.get(index));
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isMaxStrikeCount() {
        return strikeCount == Constant.MAX_STRIKE_COUNT;
    }
}
