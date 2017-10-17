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
    public boolean isDisabled() {
        return false;
    }

    @Override
    public void disable() {
        throw new UnsupportedOperationException("This object cant disable");
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {

    }
}
