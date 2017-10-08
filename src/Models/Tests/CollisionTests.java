import Models.*;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CollisionTests {

    GameMap gameMap;
    Snake snake;
    SimpleGame game;

    @Before
    public void setUp() {
        gameMap = new GameMap(20,20);
        snake = new Snake(new Point(3, 3), 6, Direction.Left,
                Direction.Right, gameMap);
        gameMap.addSnake(snake);
        game = new SimpleGame(gameMap);
    }

    @Test
    public void testEatFood() {
        FoodHeart food = new FoodHeart(new Point(2, 3));
        gameMap.addGameObject(food);
        game.makeTurn();
        assertEquals(snake.getHead(), gameMap.getMapObject(new Point(2, 3)));
        assertEquals(7, snake.getTail().toArray().length);
        assertEquals(food.getScoreCost(), game.getScore());
    }

    @Test
    public void testEatSelfTail() {
        snake.setDirection(Direction.Down);
        game.makeTurn();
        snake.setDirection(Direction.Right);
        game.makeTurn();
        snake.setDirection(Direction.Up);
        game.makeTurn();
        assertTrue(gameMap.getMapObjects().isEmpty());
    }
}
