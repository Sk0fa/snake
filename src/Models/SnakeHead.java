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

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        SnakeHead s = (SnakeHead) o;

        return s.getPosition().X == position.X && s.getPosition().Y == position.Y
                && snake == s.getSnake();
    }
}
