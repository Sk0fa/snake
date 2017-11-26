package Models;

import View.IVisitor;
import View.SimplePainter;

public class Rock extends GameObject {

    public Rock(Point position) {
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

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
