import Models.Direction;
import Models.GameMap;
import Models.Point;
import Models.Snake;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class SnakeMovementTests {

    GameMap gameMap;
    Snake snake;

    @Before
    public void setUp() {
        gameMap = new GameMap(3, 3);
        snake = new Snake(new Point(0, 0), 1, Direction.Up,
                Direction.Right, gameMap);
    }

    @Test
    public void testCorrectInitialization() {
        assertEquals(snake.getDirection(), Direction.Up);
        assertEquals(snake.getHead().getPosition(), new Point(0, 0));
        assertEquals(snake.getTail().toArray().length, 1);
        assertEquals(snake.getTail().peek().getPosition(), new Point(1, 0));
    }

    @Test
    public void testSetDirection() {
        snake.setDirection(Direction.Left);
        assertEquals(snake.getDirection(), Direction.Left);
        snake.setDirection(Direction.Right);
        assertEquals(snake.getDirection(), Direction.Left);
    }

    @Test
    public void testSnakeMove() {
        snake.move();
        assertEquals(new Point(0, 1), snake.getHead().getPosition());
        assertEquals(new Point(0, 0), snake.getTail().peek().getPosition());
    }

    @Test
    public void testCycleMove() {
        snake.setDirection(Direction.Left);
        snake.move();
        assertEquals(new Point(2, 0), snake.getHead().getPosition());
        assertEquals(new Point(0, 0), snake.getTail().peek().getPosition());
    }
}
