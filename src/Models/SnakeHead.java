package Models;

public class SnakeHead implements IGameObject {
    private Point position;
    private Snake snake;
    static private Character character = '★';

    public SnakeHead(Point position, Snake snake) {
        this.position = position;
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
        this.position = position;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public Tag getTag() {
        return Tag.SnakeHead;
    }
}
