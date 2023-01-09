package gmbs;

public class Point {
    // 볼인지 스트라이크인지 체크해주는 함수
    public boolean checkBall(int result) {
        return result == Constant.BALL;
    }

    public boolean checkStrike(int result) {
        return result == Constant.STRIKE;
    }
}
