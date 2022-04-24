package study.numberBaseballGameWithTDD;

public class Ball {
    private final Position pos;
    private final Number number;

    public Ball(Position pos, Number number) {
        this.pos = pos;
        this.number = number;
    }

    public BallStatus match(Ball input) {
        if (isInSamePosition(input) && isSameNumber(input)) return BallStatus.STRIKE;
        if (isSameNumber(input)) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean isSameNumber(Ball input) {
        return number.equals(input.number);
    }

    private boolean isInSamePosition(Ball input) {
        return pos.equals(input.pos);
    }
}
