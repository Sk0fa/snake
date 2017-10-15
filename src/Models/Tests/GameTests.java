import Models.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class GameTests {

    private GameMap gameMap;
    private SimpleGame game;

    @Before
    public void setUp() {
        gameMap = new GameMap(5, 5);
        game = new SimpleGame(gameMap);
    }

    @Test
    public void testCorrectInitialization() {
        assertEquals(5, gameMap.getWidth());
        assertEquals(5, gameMap.getHeight());
        assertEquals(0, gameMap.getMapObjects().length);
        assertEquals(gameMap, game.getMap());
    }

    @Test
    public void testMakeTurn() {
        Snake snake = new Snake(new Point(0,0), 2, Direction.Down,
                Direction.Right, gameMap);
        gameMap.addSnake(snake);
        game.makeTurn();
        assertEquals(snake.getHead(), gameMap.getMapObject(new Point(0,1)));
        assertEquals(2, snake.getTail().toArray().length);
        assertEquals(snake.getTail().toArray()[0], gameMap.getMapObject(new Point(0, 0)));
        assertEquals(snake.getTail().toArray()[1], gameMap.getMapObject(new Point(1, 0)));
    }

    @Test
    public void testGetMapObject() {
        FoodHeart food = new FoodHeart(new Point(0,0));
        gameMap.addGameObject(food);
        assertEquals(food, gameMap.getMapObject(new Point(0,0)));
        assertEquals(EmptyObject.class, gameMap.getMapObject(new Point(1, 1)).getClass());
    }

    @Test
    public void testIsFreeSpace() {
        FoodHeart food = new FoodHeart(new Point(1, 1));
        gameMap.addGameObject(food);
        assertTrue(gameMap.isFreeSpace(new Point(0, 1)));
        assertFalse(gameMap.isFreeSpace(new Point(1, 1)));
    }
}
