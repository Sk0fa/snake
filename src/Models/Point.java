package Models;

public final class Point {
    private final int X;
    private final int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Point add(Point delta, int mapWidth, int mapHeigth) {
        return new Point(
                (mapWidth + X + delta.X) % mapWidth,
                (mapHeigth + Y + delta.Y) % mapHeigth
        );
    }

    public Point scalarProduct(int scalar) {
        return new Point(scalar * X, scalar * Y);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (X != point.X) return false;
        else return Y == point.Y;
    }

    @Override
    public int hashCode() {
        int result = X;
        result = 31 * result + Y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + X + ", " + Y + ")";
    }
}
