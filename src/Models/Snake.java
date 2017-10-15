package Models;

import java.util.*;

public class Snake {
    private SnakeHead head;
    private LinkedList<SnakeTail> tail;
    private Direction direction;
    private GameMap map;

    public Snake(Point headPosition, int tailSize, Direction direction,
                 Direction tailDirection, GameMap map) {

        tail = new LinkedList<>();
        head = new SnakeHead(headPosition, this);
        Point tailChange = tailDirection.getDelta();
        for (int i = 1; i < tailSize + 1; i++) {
            Point newPosition = headPosition.add(tailChange.scalarProduct(i),
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


        if (lastTail.getIsFullTail()) {
            growTail(lastTail.getPosition());
            lastTail.setIsFullTail(false);
        }

        lastTail.setPosition(lastHeadPosition);
        tail.addFirst(lastTail);
    }

    private void moveHead(Point delta) {
        Point newPoint = head.getPosition().add(delta, map.getWidth(), map.getHeight());
        head.setPosition(newPoint);
    }

    private void growTail(Point lastTailPosition) {
        SnakeTail newTail = new SnakeTail(lastTailPosition, this, false);
        tail.addLast(newTail);
    }

    public void checkOnCollision(IGameObject[] gameObjects) {
        Arrays.stream(gameObjects)
                .filter(obj -> obj != head)
                .filter(obj -> obj.getPosition().equals(head.getPosition()))
                .forEach(this::solveCollision);
    }

    //TODO: убрать instanceof и любые явные проверки типа
    private void solveCollision(IGameObject otherObject) {
        if (otherObject.getTag() == Tag.Food) {
            otherObject.die();
            tail.peekFirst().setIsFullTail(true);
        }
        else if (otherObject.getTag() == Tag.SnakeTail || otherObject.getTag() == Tag.SnakeHead) {
            Snake snake;
            if (otherObject.getTag() == Tag.SnakeTail)
                snake = ((SnakeTail) otherObject).getSnake();
            else
                snake = ((SnakeHead) otherObject).getSnake();
            snake.die();
        }
        else if (otherObject.getTag() == Tag.DeadlyObject) {
            die();
        }
        else {
            throw new Error("Unsupported game object: " + otherObject.getClass());
        }

    }

    private void die() {
        head.die();
        tail.forEach(SnakeTail::die);
    }
}
