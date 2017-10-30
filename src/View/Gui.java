package View;

import Controller.SimpleGameController;
import Controller.SimpleSnakeController;
import Models.Direction;
import Models.IGame;
import Models.Snake;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Gui extends JFrame {

    static final int CELLSIZE = 32;
    private Thread mainThread;

    public Gui(IGame game) {
        super("Snake");

        // Контроллер для игры
        SimpleGameController gameController = new SimpleGameController(game);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameController.actionPerformed(e);
            }
        });

        // Контроллер для змеек
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

        this.setBounds(100, 100, CELLSIZE * game.getMap().getWidth(),
                CELLSIZE * game.getMap().getHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Display display = new Display(game.getMap());
        this.getContentPane().add(display);

        mainThread = new Thread(() -> startGame(game, display));
        mainThread.start();
    }

    public void startGame(IGame game, Display display) {
        while (true) {
            try {
                game.makeTurn();
                display.repaint();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
