package Models;

import java.util.Arrays;

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

        IGameObject[] newObjects = Arrays.stream(objects)
                .filter(obj -> !obj.isDead())
                .toArray(IGameObject[]::new);

        Arrays.stream(newObjects).forEach(obj -> map.addGameObject(obj));
    }
}
