package Models;

public class SnakeTail implements IGameObject {
    private Point position;

    public SnakeTail(Point position) {
        this.position = new Point(0, 0);
        this.position.X = position.X;
        this.position.Y = position.Y;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position.X = position.X;
        this.position.Y = position.Y;
    }
}
