//package Models.Tests;

import Models.Direction;
import Models.GameMap;
import Models.Point;
import Models.Snake;
import org.junit.*;
import static junit.framework.Assert.*;

public class TestClass {

    @Test
    public void testSnakeMove() {
        GameMap gameMap = new GameMap(3, 3);
        Snake snake = new Snake(new Point(0, 0), 1, Direction.Up, gameMap);
        snake.move();
        assertEquals(new Point(2, 0), snake.getHead().getPosition());
        assertEquals(new Point(0, 0), snake.getTail().get(0).getPosition());
    }

    @Test
    public void testCycleMove() {
        GameMap gameMap = new GameMap(3,3);
        Snake snake = new Snake(new Point(0, 0), 1, Direction.Right, gameMap);
        snake.move();
        assertEquals(new Point(2, 0), snake.getHead().getPosition());
        assertEquals(new Point(0, 0), snake.getTail().get(0).getPosition());
    }

}
