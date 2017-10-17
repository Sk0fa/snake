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
    public boolean isDead() {
        return false;
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Rock cant die");
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.getHead().die();
        snake.getTail().forEach(SnakeTail::die);
    }
}
