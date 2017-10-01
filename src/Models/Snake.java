package Models;

import java.util.Map;
import java.util.HashMap;

public class Snake {
    private SnakeHead head;
    private Map<Point, SnakeTail> tail;
    private Direction direction;
    private Map<Direction, Integer> intDirections;


    public Snake(Point headPosition, int tailSize, Direction direction) {
        tail = new HashMap<Point, SnakeTail>();
        head = new SnakeHead(headPosition, this);
        for (int i = 0; i < tailSize; i ++) {
            Point newPosition = new Point(headPosition.X + i + 1, headPosition.Y);
            tail.put(newPosition, new SnakeTail(newPosition));
        }

        this.direction = direction;
        intDirections = new HashMap<Direction, Integer>();
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
        int dy = 0;
        int dx = 0;
        Point lastPos = new Point(head.getPosition().X, head.getPosition().Y);
        Point lastPosTail = new Point(0, 0);

        if (direction == Direction.Up || direction == Direction.Down) {
            dy = intDirections.get(direction);
        }
        else {
            dx = intDirections.get(direction);
        }

        head.setPosition(new Point(head.getPosition().X + dx,
                head.getPosition().Y + dy));
        for (Map.Entry<Point, SnakeTail> entry : tail.entrySet()) {
            lastPosTail.X = entry.getKey().X;
            lastPosTail.Y = entry.getKey().Y;
            entry.getValue().setPosition(new Point(lastPos.X, lastPos.Y));
            lastPos.X = lastPosTail.X;
            lastPos.Y = lastPosTail.Y;
        }
    }
}
