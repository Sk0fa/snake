package Models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Snake {
    private SnakeHead head;
    private LinkedList<SnakeTail> tail;
    private Direction direction;
    private GameMap map;
    private Map<Direction, Point> DirectionChange;
    private Point lastTailPosition;

    public Snake(Point headPosition, int tailSize, Direction direction,
                 Direction tailDirection, GameMap map) {

        DirectionChange = new HashMap<>();
        DirectionChange.put(Direction.Up, new Point(0, -1));
        DirectionChange.put(Direction.Down, new Point(0, 1));
        DirectionChange.put(Direction.Right, new Point(1, 0));
        DirectionChange.put(Direction.Left, new Point(-1, 0));

        tail = new LinkedList<>();
        head = new SnakeHead(headPosition, this);
        Point tailChange = DirectionChange.get(tailDirection);
        for (int i = 1; i < tailSize + 1; i++) {
            Point newPosition = new Point(headPosition.X + i*tailChange.X,
                    headPosition.Y + i*tailChange.Y);
            tail.addLast(new SnakeTail(newPosition));
        }

        lastTailPosition = new Point(tail.getLast().getPosition().X + tailChange.X,
                tail.getLast().getPosition().Y + tailChange.Y);

        this.direction = direction;
        this.map = map;
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
        Point delta = DirectionChange.get(direction);
        Point newHeadPosition = new Point(head.getPosition().X + delta.X,
                head.getPosition().Y + delta.Y);

        if (!tail.getFirst().getPosition().equals(newHeadPosition)) {
            this.direction = direction;
        }
    }
    
    public void move() {
        Point lastHeadPosition = new Point(head.getPosition().X, head.getPosition().Y);
        moveHead(DirectionChange.get(direction));
        SnakeTail lastTail = tail.pollLast();
        lastTailPosition.X = lastTail.getPosition().X;
        lastTailPosition.Y = lastTail.getPosition().Y;
        lastTail.setPosition(new Point(lastHeadPosition.X, lastHeadPosition.Y));
        tail.addFirst(lastTail);
    }

    private void moveHead(Point delta) {
        head.setPosition(new Point(
                (map.getWidth() + head.getPosition().X + delta.X) % map.getWidth(),
                (map.getHeight() + head.getPosition().Y + delta.Y) % map.getHeight()));
    }



    public void addTail() {
        SnakeTail new_tail = new SnakeTail(new Point(lastTailPosition.X, lastTailPosition.Y));
        tail.addLast(new_tail);
        map.addGameObject(new_tail);
    }
}
