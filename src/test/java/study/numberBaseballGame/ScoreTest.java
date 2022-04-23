package study.numberBaseballGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    private final Score score = new Score();

    @BeforeEach
    void init() {
        score.init();
    }

    @Test
    @DisplayName("init 메서드를 호출하면 점수가 초기화된다")
    void test() {
        score.init();

        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.getOut()).isEqualTo(0);
    }

    @Test
    @DisplayName("점수를 입력하면 score가 업데이트 된다")
    void test2() {
        score.update(2,1,0);

        assertThat(score.getStrike()).isEqualTo(2);
        assertThat(score.getBall()).isEqualTo(1);
        assertThat(score.getOut()).isEqualTo(0);
    }
}