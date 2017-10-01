package Models;

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
    public void MakeTurn() {
        for (int i = 0; i < map.getWidth(); i++) {
            for (int k = 0; k < map.getHeight(); k++) {
                if (map.getMapObjects().containsKey(new Point(i, k))) {
                    if (map.getMapObjects().get(new Point(i, k)) instanceof SnakeHead) {
                        ((SnakeHead) map.getMapObjects().get(new Point(i, k))).getSnake().Move();
                    }
                }
            }
        }
    }
}
