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
        Snake snake = new Snake(new Point(0, 0), 1, Direction.Down, gameMap);
        gameMap.AddSnake(snake);
        snake.Move();
        assertEquals(snake.getHead().getPosition(), new Point(0, 1));
        assertEquals(snake.getTail().get(0), new Point(0, 0));
    }

}
