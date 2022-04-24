package study.numberBaseballGameWithTDD;


import java.util.Map;

import static study.numberBaseballGameWithTDD.BallStatus.*;

public class Score {

    public static ScoreStatus getScore(Map<BallStatus, Integer> count) {
        int strikeCount = count.getOrDefault(STRIKE, 0);
        int ballCount = count.getOrDefault(BALL, 0);
        int nothingCount = count.getOrDefault(NOTHING, 0);

        if (strikeCount == 3) return ScoreStatus.THREE_STRIKE;
        if (strikeCount == 2 && nothingCount == 1) return ScoreStatus.TWO_STRIKE_AND_NOTHING;
        if (strikeCount == 1 && ballCount == 2) return ScoreStatus.ONE_STRIKE_AND_TWO_BALL;
        if (strikeCount == 1 && nothingCount == 2) return ScoreStatus.ONE_STRIKE_AND_TWO_NOTHING;
        if (ballCount == 3) return ScoreStatus.THREE_BALL;
        if (nothingCount == 3) return ScoreStatus.THREE_NOTHING;

        throw new IllegalStateException("invalid state");
    }
}
