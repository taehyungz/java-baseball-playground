package study.numberBaseballGameWithTDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    @DisplayName("숫자 0을 입력하면 예외가 발생한다")
    void test() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(0));
    }

    @Test
    @DisplayName("숫자 1을 입력하면 정상 작동한다")
    void test2() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Number(1));
    }

    @Test
    @DisplayName("숫자 9을 입력하면 정상 작동한다")
    void test3() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Number(9));
    }

    @Test
    @DisplayName("숫자 10을 입력하면 예외가 발생한다.")
    void test4() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(10));
    }


}