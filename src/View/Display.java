package View;

import Models.*;
import Models.Point;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Display extends JPanel {

    private final static HashMap<Class, Color> colors = new HashMap<>();
    static
    {
        colors.put(EmptyObject.class, Color.WHITE);
        colors.put(FoodHeart.class, Color.YELLOW);
        colors.put(Rock.class, Color.BLACK);
        colors.put(SnakeHead.class, Color.RED);
        colors.put(SnakeTail.class, Color.GREEN);
    }
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

    public void paintCell(int x, int y, IGameObject object, Graphics g) {
        if (!colors.containsKey(object.getClass()))
            throw new RuntimeException(object.getClass() + " not contains in colors");
        g.setColor(colors.get(object.getClass()));
        g.fillRect(x * Gui.CELLSIZE, y * Gui.CELLSIZE, Gui.CELLSIZE, Gui.CELLSIZE);
    }
}
