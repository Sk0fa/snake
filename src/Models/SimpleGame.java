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
    public void MakeTurn() {
        checkHeads.clear();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int k = 0; k < map.getHeight(); k++) {
                if (!map.isFreeSpace(new Point(i, k))) {
                    IGameObject obj = map.GetMapObject(new Point(i, k));
                    if (obj instanceof SnakeHead && !headWasCheck((SnakeHead) obj)) {
                        ((SnakeHead) obj).getSnake().Move();
                        checkHeads.add((SnakeHead) obj);
                    }
                }
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
