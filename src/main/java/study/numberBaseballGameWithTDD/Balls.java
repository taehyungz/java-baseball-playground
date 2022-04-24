package study.numberBaseballGameWithTDD;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> numberList) {
        this.ballList = mapBallList(numberList);
    }

    private List<Ball> mapBallList(List<Integer> numberList) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ballList.add(mapBall(i, numberList.get(i)));
        }
        return ballList;
    }

    private Ball mapBall(int pos, Integer intNumber) {
        Position position = new Position(pos);
        Number number = new Number(intNumber);
        return new Ball(position, number);
    }

    public BallStatus match(Ball given) {
        return ballList.stream()
                .map(ball -> ball.match(given))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
