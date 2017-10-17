package Models;

public class EmptyObject implements IGameObject {
    private Point position;

    public EmptyObject(Point position) {
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
        return ' ';
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("This object cant die");
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {

    }
}
