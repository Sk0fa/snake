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
        Arrays.stream(objects)
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .forEach(obj -> ((SnakeHead)obj).getSnake().move());

        Snake[] allSnakes = Arrays.stream(map.getMapObjects())
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .map(head -> ((SnakeHead)head).getSnake())
                .toArray(Snake[]::new);
        Arrays.stream(allSnakes).forEach(obj -> obj.checkOnCollision(this));
    }
}
