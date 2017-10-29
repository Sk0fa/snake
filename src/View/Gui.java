package View;

import Models.IGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    static final int CELLSIZE = 32;
    private Thread mainThread;

    public Gui(IGame game) {
        super("Snake");
        this.setBounds(100, 100, CELLSIZE * game.getMap().getWidth(),
                CELLSIZE * game.getMap().getHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Display display = new Display(game.getMap());
        this.getContentPane().add(display);

        mainThread = new Thread(() -> {
            startGame(game, display);
        });
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
