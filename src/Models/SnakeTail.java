package Models;

import View.Visitor;

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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
