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
}
