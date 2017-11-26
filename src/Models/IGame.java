package Models;

public interface IGame {
    GameMap getMap();
    void makeTurn();
    byte[] serialize();
    IGame load(byte[] state);
}
