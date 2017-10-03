package Models;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Snake {
    private SnakeHead head;
    private LinkedList<SnakeTail> tail;
    private Direction direction;
    private GameMap map;
    private Map<Direction, Point> DirectionChange;

    public Snake(Point headPosition, int tailSize, Direction direction) {
        tail = new LinkedList<>();
        head = new SnakeHead(headPosition, this);
        for (int i = 0; i < tailSize; i ++) {
            Point newPosition = new Point(headPosition.X + i + 1, headPosition.Y);
            tail.addLast(new SnakeTail(newPosition));
        }

        this.direction = direction;
        this.map = map;

        DirectionChange.put(Direction.Up, new Point(0, 1));
        DirectionChange.put(Direction.Down, new Point(0, -1));
        DirectionChange.put(Direction.Right, new Point(1, 0));
        DirectionChange.put(Direction.Left, new Point(-1, 0));
    }

    public IGameObject getHead() {
        return head;
    }

    public Queue<SnakeTail> getTail() {
        return tail;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void move(GameMap gameMap) {
        Point lastHeadPosition = head.getPosition();
        moveHead(DirectionChange.get(direction), gameMap);
        SnakeTail lastTail = tail.getFirst();
        tail.addLast(lastTail);
    }

    private void moveHead(Point delta, GameMap gameMap) {
        head.setPosition(new Point((head.getPosition().X + delta.X) % gameMap.getWidth(),
                (head.getPosition().Y + delta.Y) % gameMap.getHeight()));
    }
}
