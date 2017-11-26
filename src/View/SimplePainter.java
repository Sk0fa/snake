package View;

import Models.*;
import Models.Point;

import java.awt.*;

public class SimplePainter implements IVisitor{

    private Graphics2D graphics2D;
    private Point position;

    SimplePainter(Graphics2D g, Point position) {
        graphics2D = g;
        this.position = position;
    }

    public void visit(EmptyObject object) {
        graphics2D.setColor(Color.WHITE);
        drawObject();
    }

    public void visit(FoodHeart food) {
        graphics2D.setColor(Color.YELLOW);
        drawObject();
    }

    public void visit(Rock rock) {
        graphics2D.setColor(Color.BLACK);
        drawObject();
    }

    public void visit(SnakeHead head) {
        graphics2D.setColor(Color.RED);
        drawObject();
    }

    public void visit(SnakeTail tail) {
        graphics2D.setColor(Color.GREEN);
        drawObject();
    }

    public void drawObject() {
        graphics2D.fillRect(position.getX() * Gui.CELLSIZE,
                position.getY() * Gui.CELLSIZE,
                Gui.CELLSIZE, Gui.CELLSIZE);
    }
}
