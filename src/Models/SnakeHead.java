package Models;

public class SnakeHead implements IGameObject {
    private Point position;
    private Snake snake;

    public SnakeHead(Point position, Snake snake) {
        this.position = new Point(0,0);
        this.position.X = position.X;
        this.position.Y = position.Y;
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
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
