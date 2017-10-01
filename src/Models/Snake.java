package Models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Snake {
    private SnakeHead head;
    private ArrayList<SnakeTail> tail;
    private Direction direction;
    private Map<Direction, Integer> intDirections;
    private GameMap map;


    public Snake(Point headPosition, int tailSize, Direction direction, GameMap map) {
        tail = new ArrayList<SnakeTail>();
        head = new SnakeHead(headPosition, this);
        for (int i = 0; i < tailSize; i ++) {
            Point newPosition = new Point(headPosition.X + i + 1, headPosition.Y);
            tail.add(new SnakeTail(newPosition));
        }

        this.direction = direction;
        intDirections = new HashMap<Direction, Integer>();
        intDirections.put(Direction.Down, -1);
        intDirections.put(Direction.Up, 1);
        intDirections.put(Direction.Left, -1);
        intDirections.put(Direction.Right, 1);
        this.map = map;
    }

    public IGameObject getHead() {
        return head;
    }

    public ArrayList<SnakeTail> getTail() {
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
        for (SnakeTail partOfTail : this.tail) {
            lastPosTail.X = partOfTail.getPosition().X;
            lastPosTail.Y = partOfTail.getPosition().Y;
            partOfTail.setPosition(new Point(lastPos.X, lastPos.Y));
            lastPos.X = lastPosTail.X;
            lastPos.Y = lastPosTail.Y;
        }
    }

    private void setHeadPosition(int dx, int dy) {
    }
}
