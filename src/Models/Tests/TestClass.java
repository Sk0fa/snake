package Models.Tests;

import Models.Direction;
import Models.GameMap;
import Models.Point;
import Models.Snake;
import org.junit.Test;
import static junit.framework.Assert.*;

public class TestClass {

    @Test
    public void testSnakeMove() {
        GameMap gameMap = new GameMap(3, 3);
        Snake snake = new Snake(new Point(0, 0), 1, Direction.Down, Direction.Right, gameMap);
        gameMap.addSnake(snake);
        snake.move();
        assertEquals(snake.getHead().getPosition(), new Point(0, 2));
        assertEquals(snake.getTail().peek(), new Point(0, 0));
    }

}
