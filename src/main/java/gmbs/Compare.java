package gmbs;

public class Compare {
    // Strike 여부를 판별해주는 함수
    private boolean resultIsStrike(String randomNumber, String userNumber, int index) {
        if ((randomNumber.charAt(0) == userNumber.charAt(index)) && index == 0) {
            return true;
        }

        if (randomNumber.charAt(1) == userNumber.charAt(index) && index == 1) {
            return true;
        }

        if (randomNumber.charAt(2) == userNumber.charAt(index) && index == 2) {
            return true;
        }

        return false;
    }

    // Ball 여부를 판별해주는 함수
    private boolean resultIsBall(String randomNumber, String userNumber, int index) {
        if ((randomNumber.charAt(0) == userNumber.charAt(index))) {
            return true;
        }

        if ((randomNumber.charAt(1) == userNumber.charAt(index))) {
            return true;
        }

        if ((randomNumber.charAt(2) == userNumber.charAt(index))) {
            return true;
        }

        return false;
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
        Point point = new Point();
        int ballCount = 0;
        int strikeCount = 0;

        for (int index = 0; index < Constant.NUMBER_LENGTH; index++) {
            int result = compareNumber(randomNumber, userNumber, index);
            ballCount += point.checkBall(result);
            strikeCount += point.checkStrike(result);
        }

        return Integer.toString(ballCount) + Integer.toString(strikeCount);
    }
}
