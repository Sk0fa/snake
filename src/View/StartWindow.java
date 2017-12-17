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
        String[] fileNames = Arrays.stream(files != null ? files : new File[0]).map(File::getName).toArray(String[]::new);
        JComboBox levelList = new JComboBox(fileNames);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                String selectedLevel = levelList.getSelectedIndex() != -1 ?
                        levelList.getSelectedItem().toString() : levelList.getItemAt(0).toString();
                Level levelCreator = new Level(selectedLevel);
                IGame game = levelCreator.getGame();
//                GameMap map = new GameMap(30, 20);
//                map.addSnake(new Snake(new Point(4, 17), 3, Direction.Up, Direction.Down,
//                        map));
//                for (int y = 3; y < 17; y++) {
//                    for (int x = 3; x < 22; x += 3) {
//                        map.addGameObject(new Rock(new Point(x, y)));
//                    }
//                }

/*                for (int y = 9; y > 1; y--){
//                    map.addGameObject(new Rock(new Point(3, y)));
//                }
//                for (int y = 9; y > 3; y--){
//                    map.addGameObject(new Rock(new Point  (5, y)));
//                }
//                for (int x = 4; x < 15; x++){
//                    map.addGameObject(new Rock(new Point(x, 2)));
//                }
//                for (int x = 6; x < 13; x++){
//                    map.addGameObject(new Rock(new Point(x, 4)));
//                }
//                for (int y = 9; y > 4; y--){
//                    map.addGameObject(new Rock(new Point(12, y)));
//                }
//                for (int y = 9; y > 2; y--){
//                    map.addGameObject(new Rock(new Point(14, y)));
//                }
//                map.addGameObject(new FoodHeart(new Point(8, 3)));*/
                //game = new SimpleGame(map);
                Gui gui = new Gui(game);
                gui.setVisible(true);
            }
        });
        content.add(startButton);
        content.add(levelList);
    }
}
