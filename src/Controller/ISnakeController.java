package Controller;

import Models.Direction;
import Models.Snake;

public interface ISnakeController {
    public Snake GetSnake();
    public void SetDirection(Direction direction);
}
