package gmbs;

import java.util.HashSet;

public class Compare {
    private Point point = new Point();
    private Result result = new Result();
    private HashSet<String> numberCount = new HashSet<>();

    // Strike 여부를 판별해주는 함수
    private boolean resultIsStrike(String randomNumber, String userNumber, int index) {
        return randomNumber.charAt(index) == userNumber.charAt(index);
    }

    // Ball 여부를 판별해주는 함수
    private boolean resultIsBall(String randomNumber, String userNumber, int index) {
        String targetNumber = String.valueOf(userNumber.charAt(index));

        for (int order = 0; order < randomNumber.length(); order++) {
            numberCount.add(String.valueOf(randomNumber.charAt(order)));
        }

        return numberCount.contains(targetNumber);
    }

    // 수를 비교해주는 함수
    private int compareNumber(String randomNumber, String userNumber, int index) {
        // 볼을 먼저 체크하면 스트라이크가 볼로 출력 됨
        if (resultIsStrike(randomNumber, userNumber, index)) {
            return Constant.STRIKE;
        }

        if (resultIsBall(randomNumber, userNumber, index)) {
            return Constant.BALL;
        }

        return Constant.NOT_EXIST;
    }

    public String checkResult(String randomNumber, String userNumber) {
        result.setBallCount(0);
        result.setStrikeCount(0);

        for (int index = 0; index < Constant.NUMBER_LENGTH; index++) {
            int outcome = compareNumber(randomNumber, userNumber, index);

            if (point.checkBall(outcome)) {
                result.addBall();
            }

            if (point.checkStrike(outcome)) {
                result.addStrike();
            }
        }

        return Integer.toString(result.getBallCount()) + Integer.toString(result.getStrikeCount());
    }
}
