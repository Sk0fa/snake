package Controller;

import Models.Direction;
import Models.Snake;

public class SimpleSnakeController implements ISnakeController{

    private Snake snake;

    public SimpleSnakeController(Snake snake) {
        this.snake = snake;
    }

    @Override
    public Snake GetSnake() {
        return snake;
    }

    @Override
    public void SetDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
