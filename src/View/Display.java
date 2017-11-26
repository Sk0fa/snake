package View;

import Models.*;
import Models.Point;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private GameMap map;

    public Display(GameMap map) {
        this.map = map;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int y = 0; y < map.getHeight(); y++)
            for(int x = 0; x < map.getWidth(); x++)
                paintCell(x, y, map.getMapObject(new Point(x, y)), g2);
    }

    public void paintCell(int x, int y, IGameObject object, Graphics2D g) {
        SimplePainter visitor = new SimplePainter(g, new Point(x, y));
        object.accept(visitor);
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
