package View;

import Models.*;
import Models.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

public class StartWindow extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public StartWindow()
    {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        Container content = getContentPane();
        content.setLayout(new FlowLayout());

        File levelDirectory = new File("levels");
        File[] files = levelDirectory.listFiles();
        String[] fileNames = Arrays.stream(files).map(File::getName).toArray(String[]::new);
        JComboBox levelList = new JComboBox(fileNames);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

//                GameMap map = new GameMap(7, 7);
//                Snake snake = new Snake(new Point(3, 3), 2,
//                                        Direction.Up, Direction.Right, map);
//                FoodHeart heart = new FoodHeart(new Point(3, 0));
//                map.addGameObject(heart);
//                map.addSnake(snake);
//                SimpleGame game = new SimpleGame(map);

                Level levelCreator = new Level((String)levelList.getSelectedItem());
                IGame game = levelCreator.loadGame();
                Gui gui = new Gui(game);
                gui.setVisible(true);
            }
        });
        content.add(startButton);
        content.add(levelList);
    }
}
