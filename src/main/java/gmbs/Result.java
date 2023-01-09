package gmbs;

public class Result {
    private int ballCount = 0;
    private int strikeCount = 0;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void addBall() {
        ballCount++;
    }

    public void addStrike() {
        strikeCount++;
    }
}
