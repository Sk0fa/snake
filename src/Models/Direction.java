package Models;

public enum Direction {
    Up (new Point(0, -1)),
    Down (new Point(0, 1)),
    Right (new Point(1, 0)),
    Left (new Point(-1, 0));

    private final Point delta;

    Direction(Point point) {
        delta = point;
    }

    public Point getDelta() {
        return delta;
    }
}
