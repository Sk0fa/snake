package Models;

public class Rock implements IGameObject {

    private Point position;

    public Rock(Point position) {
        this.position = position;
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
        return '#';
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public void disable() {
        throw new UnsupportedOperationException("Rock cant disable");
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.getHead().disable();
        snake.getTail().forEach(SnakeTail::disable);
    }
}
