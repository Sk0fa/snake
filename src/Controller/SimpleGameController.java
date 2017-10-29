package Controller;

import Models.IGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGameController implements IGameController{

    private IGame game;

    public SimpleGameController(IGame game) {
        this.game = game;
    }

    @Override
    public IGame GetGame() {
        return this.game;
    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }

    }
}
