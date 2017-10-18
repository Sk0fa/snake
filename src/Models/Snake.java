package Models;

import java.util.*;

public class Snake {
    private SnakeHead head;
    private LinkedList<SnakeTail> tail;
    private Direction direction;
    private GameMap map;
    private int fullness = 0;

    public Snake(Point headPosition, int tailSize, Direction direction,
                 Direction tailDirection, GameMap map) {

        tail = new LinkedList<>();
        head = new SnakeHead(headPosition, this);
        Point tailChange = tailDirection.getDelta();
        for (int i = 1; i < tailSize + 1; i++) {
            Point newPosition = headPosition.add(tailChange.multiplicationByScalar(i),
                    map.getWidth(), map.getHeight());
            tail.addLast(new SnakeTail(newPosition, this, false));
        }

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
        Point delta = direction.getDelta();
        Point newHeadPosition = head.getPosition().add(delta, map.getWidth(), map.getHeight());

        if (!tail.getFirst().getPosition().equals(newHeadPosition)) {
            this.direction = direction;
        }
    }
    
    public void move() {
        Point lastHeadPosition = head.getPosition();
        moveHead(direction.getDelta());
        SnakeTail lastTail = tail.pollLast();


        if (lastTail.isFullTail()) {
            growTail(lastTail.getPosition());
        }

        SnakeTail newTail = new SnakeTail(lastHeadPosition, this, fullness > 0);
        if (fullness > 0) fullness--;

        tail.addFirst(newTail);
        lastTail.disable();
    }

    private void moveHead(Point delta) {
        Point newPoint = head.getPosition().add(delta, map.getWidth(), map.getHeight());
        head.setPosition(newPoint);
    }

    private void growTail(Point lastTailPosition) {
        SnakeTail newTail = new SnakeTail(lastTailPosition, this, false);
        tail.addLast(newTail);
    }

    public void eatFood(IFood food) {
        fullness += food.getFoodValue();
    }

    public void checkOnCollision(IGameObject[] gameObjects) {
        Arrays.stream(gameObjects)
                .filter(obj -> obj != head)
                .filter(obj -> obj.getPosition().equals(head.getPosition()))
                .forEach(gameObject -> gameObject.solveCollisionWithSnake(this));
    }

    public void die() {
        head.disable();
        tail.forEach(SnakeTail::disable);
        map.removeSnake(this);
    }
}
