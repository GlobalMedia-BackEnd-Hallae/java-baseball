package gmbs;

public class Output {
    private int ballCount;
    private int strikeCount;

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    private void nothing() {
        System.out.println("낫싱");
    }

    private void strike() {
        System.out.println(strikeCount + "스트라이크");
    }

    private void ball() {
        System.out.println(ballCount + "볼");
    }

    private void ballAndStrike() {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public int output(String ballAndStrikeCount) {
        setBallCount(ballAndStrikeCount.charAt(Constant.BALL) - Constant.ASCII_CODE_OF_ZERO);
        setStrikeCount(ballAndStrikeCount.charAt(Constant.STRIKE) - Constant.ASCII_CODE_OF_ZERO);

        if (ballCount == 0 && strikeCount == 0) {
            nothing();
        } else if (ballCount == 0) {
            strike();
        } else if (strikeCount == 0) {
            ball();
        } else {
            ballAndStrike();
        }

        if (strikeCount == Constant.NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return Constant.END;
        }

        return Constant.CONTINUE;
    }
}
