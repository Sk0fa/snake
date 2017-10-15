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
        IGameObject[] objects = map.getMapObjects().toArray(new IGameObject[map.getMapObjects().size()]);
        Arrays.stream(objects)
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .forEach(obj -> ((SnakeHead)obj).getSnake().move());

        Snake[] allSnakes = map.getMapObjects().stream()
                .filter(obj -> obj.getTag() == Tag.SnakeHead)
                .map(head -> ((SnakeHead)head).getSnake())
                .toArray(Snake[]::new);
        Arrays.stream(allSnakes).forEach(obj -> obj.checkOnCollision(this));
    }
}
