package mouse;

import java.util.Objects;

public class MousePointerCoordinates {
    private final int x;
    private final int y;

    public MousePointerCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MousePointerCoordinates that = (MousePointerCoordinates) o;
        return x == that.x && y == that.y;
    }
}
