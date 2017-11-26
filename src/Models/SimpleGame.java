package Models;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SimpleGame implements IGame, Serializable {

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
        Snake[] snakes = map.getSnakes();
        map.clearMap();

        Arrays.stream(snakes).forEach(Snake::move);
        Arrays.stream(snakes).forEach(snake -> snake.checkOnCollision(objects));

        HashSet<IGameObject> newObjects = Arrays.stream(objects)
                .filter(obj -> !obj.isDisabled())
                .collect(Collectors.toCollection(HashSet::new));

        Arrays.stream(snakes)
                .filter(snake -> !snake.getHead().isDisabled())
                .forEach(snake -> newObjects.addAll(snake.getTail()));

        newObjects.forEach(obj -> map.addGameObject(obj));
    }
}
