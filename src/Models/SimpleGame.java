package Models;

import java.util.ArrayList;

public class SimpleGame implements IGame {

    GameMap map;
    ArrayList<SnakeHead> checkHeads;

    public SimpleGame(GameMap map) {
        this.map = map;
        checkHeads = new ArrayList<SnakeHead>();
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

    private boolean headWasCheck(SnakeHead head) {
        for (SnakeHead h : checkHeads) {
            if (h.equals(head)) {
                return true;
            }
        }

        return false;
    }
}
