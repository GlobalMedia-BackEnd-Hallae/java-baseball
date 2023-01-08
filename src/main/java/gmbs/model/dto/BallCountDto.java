package gmbs.model.dto;

public class BallCountDto {

    private static final int MAX_STRIKE_COUNT = 3;

    private final int strike;
    private final int ball;

    public BallCountDto(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isOnlyStrike() {
        return strike != 0 && ball == 0;
    }

    public boolean isOnlyBall() {
        return strike == 0 && ball != 0;
    }

    public boolean isStrikeAndBall() {
        return strike != 0 && ball != 0;
    }

    public boolean isMaxStrike() {
        return strike == MAX_STRIKE_COUNT;
    }
}
