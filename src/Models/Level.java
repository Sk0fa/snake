package Models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Level {
    private IGame game;

    public Level(String filename) {
        loadGame(filename);
    }

    public void loadGame(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("levels/" + filename))) {
            IGame loadGame = (IGame)ois.readObject();
            this.game = loadGame;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public IGame getGame() {
        return game;
    }
}
