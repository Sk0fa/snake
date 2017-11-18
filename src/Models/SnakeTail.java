package Models;

import View.IVisitor;
import View.SimplePainter;

public class SnakeTail extends GameObject {
    private Snake parentSnake;
    private final boolean isFullTail;
    static private Character character = '☯';

    public SnakeTail(Point position, Snake parentSnake, boolean isFullTail) {
        this.position = position;
        this.parentSnake = parentSnake;
        this.isFullTail = isFullTail;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.die();
    }

    public Snake getSnake() {
        return parentSnake;
    }

    public boolean isFullTail() {
        return isFullTail;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
