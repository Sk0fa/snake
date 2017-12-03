package Models;

import View.IVisitor;

public class SnakeHead extends GameObject {
    private Snake snake;

    public SnakeHead(Point position, Snake snake) {
        this.position = position;
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.die();
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
