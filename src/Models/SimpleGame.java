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
        
    }
}
