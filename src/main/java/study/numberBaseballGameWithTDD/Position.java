package study.numberBaseballGameWithTDD;

import java.util.Objects;

public class Position {
    private final int pos;

    public Position(int pos) {
        if (pos < 0 || pos > 2) throw new IllegalArgumentException("위치값은 0부터 2까지만 가능합니다.");
        this.pos = pos;
    }

    public int getPosition() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return pos == position.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }
}
