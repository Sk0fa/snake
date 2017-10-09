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
            Point newPosition = new Point(headPosition.X + i*tailChange.X,
                    headPosition.Y + i*tailChange.Y);
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

    //TODO: вынести сложение в отдельный метод
    //TODO: immutable point
    public void setDirection(Direction direction) {
        Point delta = direction.getDelta();
        Point newHeadPosition = new Point(head.getPosition().X + delta.X,
                head.getPosition().Y + delta.Y);

        if (!tail.getFirst().getPosition().equals(newHeadPosition)) {
            this.direction = direction;
        }
    }
    
    public void move() {
        Point lastHeadPosition = new Point(head.getPosition().X, head.getPosition().Y);
        moveHead(direction.getDelta());
        SnakeTail lastTail = tail.pollLast();
        if (lastTail.getFullTail())
            growTail(lastTail.getPosition());

        lastTail.setPosition(lastHeadPosition);
        lastTail.setFullTail(false);
        tail.addFirst(lastTail);
    }

    private void moveHead(Point delta) {
        head.setPosition(new Point(
                (map.getWidth() + head.getPosition().X + delta.X) % map.getWidth(),
                (map.getHeight() + head.getPosition().Y + delta.Y) % map.getHeight()));
    }

    private void growTail(Point lastTailPosition) {
        tail.addLast(new SnakeTail(lastTailPosition, this, false));
    }

    public void checkOnCollision(IGame game) {
        List<IGameObject> objects = game.getMap().getMapObjectsInCell(head.getPosition());
        objects.stream()
                .filter(object -> object != head)
                .forEach(object -> solveCollision(object, game));
    }

    //TODO: убрать instanceof и любые явные проверки типа
    private void solveCollision(IGameObject otherObject, IGame game) {
        if (otherObject instanceof IFood) {
            ((IFood) otherObject).destroyFood(game);
            tail.peekFirst().setFullTail(true);
        }
        else if (otherObject instanceof SnakeTail || otherObject instanceof SnakeHead) {
            Snake snake;
            if (otherObject instanceof SnakeTail)
                snake = ((SnakeTail) otherObject).getSnake();
            else
                snake = ((SnakeHead) otherObject).getSnake();
            snake.die(game);
        }
        else if (otherObject instanceof Rock) {
            die(game);
        }
        else {
            throw new Error("Unsupported game object: " + otherObject.getClass());
        }

    }

    public void die(IGame game) {
        game.getMap().getMapObjects().remove(head);
        tail.forEach(tailPart -> game.getMap().getMapObjects().remove(tailPart));
    }
}
