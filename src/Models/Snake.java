package Models;

import java.util.Map;
import java.util.HashMap;

public class Snake {
    private IGameObject head;
    private Map<Point, IGameObject> tail;
    private Direction direction;

    public Snake(Point headPosition, int tailSize, Direction direction) {

    }

    public IGameObject getHead() {
        return head;
    }

    public Map<Point, IGameObject> getTail() {
        return tail;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void Move() {

    }
}
