package Controller;

import Models.IGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleGameController implements IGameController{

    private IGame game;

    public SimpleGameController(IGame game) {
        this.game = game;
    }

    @Override
    public IGame GetGame() {
        return this.game;
    }

    public void actionPerformed(KeyEvent actionEvent) {
    }
}
