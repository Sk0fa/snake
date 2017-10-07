package Models;

import java.util.ArrayList;

public class SimpleGame implements IGame {

    private GameMap map;
    private int score;

    public SimpleGame(GameMap map) {
        this.map = map;
        score = 0;
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

        for (int i = 0; i < map.getMapObjects().size(); i++) {
            map.getMapObjects().get(i).checkOnCollision(this);
        }
    }

    @Override
    public void changeScore(int scoreCount) {
        score += scoreCount;
    }

    @Override
    public int getScore() {
        return score;
    }
}
