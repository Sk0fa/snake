package Models;

public class Point {
    public int X;
    public int Y;

    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        Point p = (Point) o;

        return p.X == X && p.Y == Y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + X;
        result = result * 37 + Y;

        return result;
    }
}
