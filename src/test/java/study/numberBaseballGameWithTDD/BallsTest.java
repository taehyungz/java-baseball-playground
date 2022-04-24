package study.numberBaseballGameWithTDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {

    @Test
    @DisplayName("Nothing test")
    void test() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball given = new Ball(new Position(0), new Number(4));

        BallStatus status = answer.match(given);

        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("Ball test")
    void test2() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball given = new Ball(new Position(0), new Number(3));

        BallStatus status = answer.match(given);

        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Strike test")
    void test3() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball given = new Ball(new Position(0), new Number(1));

        BallStatus status = answer.match(given);

        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("THREE_STRIKE")
    void test4() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(1, 2, 3));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.THREE_STRIKE);
    }

    @Test
    @DisplayName("TWO_STRIKE_AND_NOTHING")
    void test5() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(1, 2, 4));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.TWO_STRIKE_AND_NOTHING);
    }

    @Test
    @DisplayName("ONE_STRIKE_AND_TWO_BALL")
    void test6() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(1, 3, 2));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.ONE_STRIKE_AND_TWO_BALL);
    }

    @Test
    @DisplayName("ONE_STRIKE_AND_TWO_OUT")
    void test7() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(1, 4, 5));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.ONE_STRIKE_AND_TWO_NOTHING);
    }

    @Test
    @DisplayName("THREE_BALL")
    void test8() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(3, 1, 2));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.THREE_BALL);
    }

    @Test
    @DisplayName("THREE_NOTHING")
    void test9() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls expected = new Balls(Arrays.asList(4, 5, 6));

        ScoreStatus score = answer.matchAll(expected);

        Assertions.assertThat(score).isEqualTo(ScoreStatus.THREE_NOTHING);
    }
}
