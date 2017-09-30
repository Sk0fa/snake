package Controller;

import Models.IGame;

public class SimpleGameController implements IGameController{

    private IGame game;

    public SimpleGameController(IGame game) {
        this.game = game;
    }

    @Override
    public IGame GetGame() {
        return this.game;
    }
}
