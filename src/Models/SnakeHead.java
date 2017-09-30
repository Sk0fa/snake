package Models;

public class SnakeHead implements IGameObject {
    private Point position;

    public SnakeHead(Point position) {
        this.position = position;
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
