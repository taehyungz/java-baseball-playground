package study.numberBaseballGameWithTDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    @DisplayName("입력한 수가 정답과 위치와 숫자 모두 같다면 볼을 반환한다.")
    void test() {
        Ball answer = new Ball(1, 3);

        BallStatus status = answer.match(new Ball(1, 3));

        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("입력한 수가 정답과 위치는 다르지만 숫자는 같다면 볼을 반환한다.")
    void test2() {
        Ball answer = new Ball(1, 3);

        BallStatus status = answer.match(new Ball(2, 3));

        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("입력한 수가 정답과 위치와 숫자 모두 다르다면 아웃을 반환한다.")
    void test3() {
        Ball answer = new Ball(1, 3);

        BallStatus status = answer.match(new Ball(1, 2));

        Assertions.assertThat(status).isEqualTo(BallStatus.OUT);
    }
}
