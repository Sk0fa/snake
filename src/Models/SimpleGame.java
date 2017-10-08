package Models;

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
        map.getMapObjects().stream()
                .filter(obj -> obj instanceof SnakeHead)
                .forEach(obj -> ((SnakeHead)obj).getSnake().move());


        map.getMapObjects().forEach(obj -> obj.checkOnCollision(this));
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
