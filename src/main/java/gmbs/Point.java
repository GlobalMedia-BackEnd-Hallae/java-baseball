package gmbs;

public class Point {
    // 볼인지 스트라이크인지 체크해주는 함수
    public int checkBall(int result) {
        if (result == Constant.BALL) {
            return 1;
        }

        return 0;
    }

    public int checkStrike(int result) {
        if (result == Constant.STRIKE) {
            return 1;
        }

        return 0;
    }
}
