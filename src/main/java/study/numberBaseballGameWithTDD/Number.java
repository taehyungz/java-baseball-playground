package study.numberBaseballGameWithTDD;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        if (number <= 0 || number > 9) throw new IllegalArgumentException("숫자는 1부터 9까지만 가능합니다.");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
