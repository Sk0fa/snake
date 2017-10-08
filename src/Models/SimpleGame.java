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
        map.getMapObjects().stream()
                .filter(obj -> obj instanceof SnakeHead)
                .forEach(obj -> ((SnakeHead)obj).getSnake().move());

        Object[] allSnakes = map.getMapObjects().stream()
                .filter(obj -> obj instanceof SnakeHead)
                .map(head -> ((SnakeHead)head).getSnake())
                .toArray();
        Arrays.stream(allSnakes).forEach(obj -> ((Snake)obj).checkOnCollision(this));
    }
}
