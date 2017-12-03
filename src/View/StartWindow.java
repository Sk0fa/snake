package View;

import Models.Level;

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

            }
        });
        content.add(startButton);
        content.add(levelList);

    }

}
