package study.numberBaseballGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeNumbersTest {

    private final ThreeNumbers threeNumbers = new ThreeNumbers();

    @BeforeEach
    void init() {
        threeNumbers.init();
    }

    @Test
    @DisplayName("init 메서드를 사용하면 세 수가 모두 0으로 초기화된다")
    void test() {
        threeNumbers.init();

        Assertions.assertThat(threeNumbers.getFirst()).isEqualTo(0);
        Assertions.assertThat(threeNumbers.getSecond()).isEqualTo(0);
        Assertions.assertThat(threeNumbers.getThird()).isEqualTo(0);
    }

    @Test
    @DisplayName("1부터 9사이의 숫자 3개를 연달아 입력하면 ThreeNumbers 객체에 저장이 잘 된다")
    void test2() {
        String given = "123";

        threeNumbers.insertExpectedThreeNumbers(given);

        Assertions.assertThat(threeNumbers.getFirst()).isEqualTo(1);
        Assertions.assertThat(threeNumbers.getSecond()).isEqualTo(2);
        Assertions.assertThat(threeNumbers.getThird()).isEqualTo(3);
    }

    @Test
    @DisplayName("generateRandomNumber메서드를 이용하면 유니크한 숫자 세 개가 ThreeNumbers에 저장된다")
    void test3() {
        threeNumbers.generateThreeRandomNumbers();

        Assertions.assertThat(threeNumbers.getFirst()).isNotEqualTo(threeNumbers.getSecond());
        Assertions.assertThat(threeNumbers.getFirst()).isNotEqualTo(threeNumbers.getThird());
        Assertions.assertThat(threeNumbers.getSecond()).isNotEqualTo(threeNumbers.getThird());
    }
}