package study.numberBaseballGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberMatcherTest {

    private final NumberMatcher numberMatcher = new NumberMatcher();
    ThreeNumbers answer = new ThreeNumbers(1, 2, 3);
    ThreeNumbers expected = new ThreeNumbers();

    @Test
    @DisplayName("3S")
    void test() {
        expected.insertExpectedThreeNumbers("123");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(3);
        Assertions.assertThat(score.getBall()).isEqualTo(0);
        Assertions.assertThat(score.getOut()).isEqualTo(0);
    }

    @Test
    @DisplayName("2S 1O")
    void test2() {
        expected.insertExpectedThreeNumbers("124");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(2);
        Assertions.assertThat(score.getBall()).isEqualTo(0);
        Assertions.assertThat(score.getOut()).isEqualTo(1);
    }

    @Test
    @DisplayName("1S 2B")
    void test3() {
        expected.insertExpectedThreeNumbers("132");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(1);
        Assertions.assertThat(score.getBall()).isEqualTo(2);
        Assertions.assertThat(score.getOut()).isEqualTo(0);
    }

    @Test
    @DisplayName("1S 2O")
    void test4() {
        expected.insertExpectedThreeNumbers("145");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(1);
        Assertions.assertThat(score.getBall()).isEqualTo(0);
        Assertions.assertThat(score.getOut()).isEqualTo(2);
    }

    @Test
    @DisplayName("3B")
    void test5() {
        expected.insertExpectedThreeNumbers("231");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(0);
        Assertions.assertThat(score.getBall()).isEqualTo(3);
        Assertions.assertThat(score.getOut()).isEqualTo(0);
    }

    @Test
    @DisplayName("3O")
    void test6() {
        expected.insertExpectedThreeNumbers("456");

        Score score = numberMatcher.calculateScore(expected, answer);
        Assertions.assertThat(score.getStrike()).isEqualTo(0);
        Assertions.assertThat(score.getBall()).isEqualTo(0);
        Assertions.assertThat(score.getOut()).isEqualTo(3);
    }
}