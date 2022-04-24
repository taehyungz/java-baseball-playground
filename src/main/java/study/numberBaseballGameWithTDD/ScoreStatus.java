package study.numberBaseballGameWithTDD;

public enum ScoreStatus {
    THREE_STRIKE(3, 0, 0),
    TWO_STRIKE_AND_NOTHING(2, 0, 1),
    ONE_STRIKE_AND_TWO_BALL(1, 2, 0),
    ONE_STRIKE_AND_TWO_NOTHING(1, 0, 2),
    THREE_BALL(0, 3, 0),
    THREE_NOTHING(0, 0, 3),
    ;

    public final int strike;
    public final int ball;
    public final int nothing;

    ScoreStatus(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }
}
