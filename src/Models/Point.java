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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (X != point.X) return false;
        return Y == point.Y;
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
