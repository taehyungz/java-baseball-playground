package study.numberBaseballGameWithTDD;

public class Ball {
    private int pos;
    private int number;

    public Ball(int pos, int number) {
        this.pos = pos;
        this.number = number;
    }

    public BallStatus match(Ball input) {
        if (pos == input.pos && number == input.number) return BallStatus.STRIKE;
        if (number == input.number) return BallStatus.BALL;
        return BallStatus.OUT;
    }
}
