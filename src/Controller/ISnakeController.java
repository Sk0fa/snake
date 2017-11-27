package Controller;

import Models.Direction;
import Models.Snake;

public interface ISnakeController {
    Snake getSnake();
    void setDirection(Direction direction);
}
