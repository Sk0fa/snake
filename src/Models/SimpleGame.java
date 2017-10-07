package Models;

import java.util.ArrayList;

public class SimpleGame implements IGame {

    GameMap map;

    public SimpleGame(GameMap map) {
        this.map = map;
    }

    @Override
    public GameMap getMap() {
        return map;
    }

    @Override
    public void makeTurn() {
        for (IGameObject obj : map.getMapObjects()) {
            if (obj instanceof SnakeHead) {
                ((SnakeHead) obj).getSnake().move();
            }
        }
    }
}
