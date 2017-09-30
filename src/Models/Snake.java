package Models;

import java.util.Map;
import java.util.HashMap;

public class Snake {
    private SnakeHead head;
    private Map<Point, SnakeTail> tail;
    private Direction direction;
    private Map<Direction, Integer> intDirections;


    public Snake(Point headPosition, int tailSize, Direction direction) {
        head = new SnakeHead(headPosition);
        for (int i = 0; i < tailSize; i ++) {
            Point newPosition = new Point(headPosition.X + i + 1, headPosition.Y);
            tail.put(newPosition, new SnakeTail(newPosition));
        }

        this.direction = direction;
        intDirections.put(Direction.Down, -1);
        intDirections.put(Direction.Up, 1);
        intDirections.put(Direction.Left, -1);
        intDirections.put(Direction.Right, 1);
    }

    public IGameObject getHead() {
        return head;
    }

    public Map<Point, SnakeTail> getTail() {
        return tail;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void Move() {
        //if (direction == Direction.Up ||)
    }
}
