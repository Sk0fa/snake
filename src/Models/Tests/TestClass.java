import Models.Direction;
import Models.Point;
import Models.Snake;
import org.junit.Test;
import static junit.framework.Assert.*;

public class TestClass {

    @Test
    public void testSnakeMove() {
        Snake snake = new Snake(new Point(0, 0), 2, Direction.Down);
        snake.Move();
        assertEquals(snake.getDirection(), Direction.Down);
        assertEquals(snake.getHead().getPosition(), new Point(0, 1));
    }

}
