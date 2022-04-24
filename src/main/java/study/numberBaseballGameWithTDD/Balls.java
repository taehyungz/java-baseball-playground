package study.numberBaseballGameWithTDD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> numberList) {
        this.ballList = mapBallList(numberList);
    }

    public static Balls from(String expected) {
        int first = Integer.parseInt(expected.substring(0, 1));
        int second = Integer.parseInt(expected.substring(1, 2));
        int third = Integer.parseInt(expected.substring(2,3));
        return new Balls(List.of(first, second, third));
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

    public ScoreStatus matchAll(Balls expected) {
        Map<BallStatus, Integer> countMap = getBallStatusCountByMatchEach(expected);
        return Score.from(countMap);
    }

    private Map<BallStatus, Integer> getBallStatusCountByMatchEach(Balls expected) {
        Map<BallStatus, Integer> countMap = new HashMap<>();

        for (Ball ball : expected.ballList) {
            addOneCount(countMap, ball);
        }
        return countMap;
    }

    private void addOneCount(Map<BallStatus, Integer> countMap, Ball ball) {
        BallStatus status = this.match(ball);
        countMap.put(status, countMap.getOrDefault(status, 0) + 1);
    }

    public static Balls randomBalls() {
        List<Integer> randomNumberList = getRandomUniqueNumberList();
        return new Balls(randomNumberList);
    }

    private static List<Integer> getRandomUniqueNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        randomNumberList.add(generateRandomNumber());
        randomNumberList.add(generateRandomNumberWithoutBannedNumber(randomNumberList));
        randomNumberList.add(generateRandomNumberWithoutBannedNumber(randomNumberList));
        return randomNumberList;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 9) + 1;
    }

    private static int generateRandomNumberWithoutBannedNumber(List<Integer> bannedNumberList) {
        int uniqueNumber = generateRandomNumber();
        while (bannedNumberList.contains(uniqueNumber)) {
            uniqueNumber = generateRandomNumber();
        }
        return uniqueNumber;
    }
}
