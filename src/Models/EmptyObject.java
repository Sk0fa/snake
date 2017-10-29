package Models;

public class EmptyObject extends GameObject {
    public EmptyObject(Point position) {
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
