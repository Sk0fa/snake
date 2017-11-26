package View;

import Controller.ISnakeController;
import Controller.SimpleGameController;
import Controller.SimpleSnakeController;
import Models.Direction;
import Models.IGame;
import Models.Snake;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Gui extends JFrame {


    static final int CELLSIZE = 32;
    private IGame game;
    private Display display;

    public Gui(IGame game) {
        super("Snake");
        this.game = game;

        createGameController();
        createSnakeControllers();

        this.setBounds(100, 100, CELLSIZE * game.getMap().getWidth(),
                CELLSIZE * game.getMap().getHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        display = new Display(game.getMap());
        this.getContentPane().add(display);

        Timer timer = new Timer(200, e -> makeFrame());
        timer.start();
    }

    private void createGameController() {
        SimpleGameController gameController = new SimpleGameController(game, this);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameController.actionPerformed(e);
            }
        });
    }

    private void createSnakeControllers() {
        for(Snake snake : game.getMap().getSnakes()) {
            HashMap<Integer, Direction> actions = new HashMap<>();
            actions.put(KeyEvent.VK_A, Direction.Left);
            actions.put(KeyEvent.VK_D, Direction.Right);
            actions.put(KeyEvent.VK_W, Direction.Up);
            actions.put(KeyEvent.VK_S, Direction.Down);
            SimpleSnakeController snakeController = new SimpleSnakeController(snake, actions);
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    snakeController.actionPerformed(e);
                }
            });
        }
    }

    private void makeFrame() {
        game.makeTurn();
        display.repaint();
    }

    public void setGame(IGame game) {
        this.game = game;
        display.setMap(game.getMap());
        createGameController();
        createSnakeControllers();
    }

}
