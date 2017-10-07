package Models;

public interface IGame {
    public GameMap getMap();
    public void makeTurn();
    public void changeScore(int scoreCount);
    public int getScore();
}
