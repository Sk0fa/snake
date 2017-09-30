package Models;

public class Game implements IGame {

    GameMap map;

    public Game(GameMap map) {
        this.map = map;
    }

    @Override
    public GameMap getMap() {
        return map;
    }

    @Override
    public void MakeTurn() {

    }
}
