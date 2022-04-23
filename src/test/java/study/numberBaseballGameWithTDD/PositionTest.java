package study.numberBaseballGameWithTDD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("위치가 -1이면 예외가 발생한다")
    void test() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @Test
    @DisplayName("위치가 0이면 정상작동한다")
    void test2() {
        assertDoesNotThrow(() -> new Position(0));
    }

    @Test
    @DisplayName("위치가 2이면 예외가 발생한다")
    void test3() {
        assertDoesNotThrow(() -> new Position(2));
    }

    @Test
    @DisplayName("위치가 3이면 예외가 발생한다")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> new Position(3));
    }
}