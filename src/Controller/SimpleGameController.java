package Controller;

import Models.IGame;
import View.Gui;

import java.awt.event.KeyEvent;
import java.io.*;

public class SimpleGameController implements IGameController {

    private static final String FILENAME = "data.dat";
    private IGame game;
    private Gui gui;

    public SimpleGameController(IGame game, Gui gui) {
        this.game = game;
        this.gui = gui;
    }

    @Override
    public IGame getGame() {
        return this.game;
    }

    public void actionPerformed(KeyEvent actionEvent) {
        switch (actionEvent.getKeyCode()) {
            case KeyEvent.VK_F5:
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                    oos.writeObject(this.game);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyEvent.VK_F6:
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                    IGame loadGame = (IGame)ois.readObject();
                    gui.setGame(loadGame);
                } catch (ClassNotFoundException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
