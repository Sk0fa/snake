package Models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class SimpleGame implements IGame {

    private GameMap map;

    public SimpleGame(GameMap map) {
        this.map = map;
    }

    @Override
    public GameMap getMap() {
        return map;
    }

    @Override
    public void makeTurn() {
        IGameObject[] objects = map.getMapObjects();
        map.clearMap();
        Arrays.stream(objects)
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .forEach(obj -> ((SnakeHead)obj).getSnake().move());

        Arrays.stream(objects)
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .map(head -> ((SnakeHead)head).getSnake())
                .forEach(snake -> snake.checkOnCollision(objects));

        HashSet<IGameObject> newObjects = Arrays.stream(objects)
                .filter(obj -> !obj.isDead())
                .collect(Collectors.toCollection(HashSet::new));

        Arrays.stream(objects)
                .filter(obj -> !obj.isDead())
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .map(obj -> ((SnakeHead)obj).getSnake())
                .forEach(obj -> newObjects.addAll(obj.getTail()));

        newObjects.forEach(obj -> map.addGameObject(obj));
    }
}
