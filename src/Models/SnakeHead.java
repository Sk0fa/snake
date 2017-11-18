package Models;

import View.Visitor;

public class SnakeHead extends GameObject {
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
    public Character getCharacter() {
        return character;
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        snake.die();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
