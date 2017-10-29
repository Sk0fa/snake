package Controller;

import Models.Direction;
import Models.Snake;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class SimpleSnakeController implements ISnakeController{

    private Snake snake;
    private HashMap<Integer, Direction> actions;

    public SimpleSnakeController(Snake snake, HashMap<Integer, Direction> actions) {
        this.snake = snake;
        this.actions = actions;
    }

    @Override
    public Snake GetSnake() {
        return snake;
    }

    @Override
    public void SetDirection(Direction direction) {
        snake.setDirection(direction);
    }

    public void actionPerformed(KeyEvent actionEvent) {
        if (actions.containsKey(actionEvent.getKeyCode())) {
            snake.setDirection(actions.get(actionEvent.getKeyCode()));
        }
    }
}
