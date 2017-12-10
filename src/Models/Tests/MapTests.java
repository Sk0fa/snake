import Models.FoodHeart;
import Models.GameMap;
import Models.Point;
import Models.Rock;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MapTests {

    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap(5, 5);
    }

    @Test
    public void testFullMap() {
        assertEquals(false, map.isFullMap());
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Rock rock = new Rock(new Point(i, j));
                map.addGameObject(rock);
            }
        }
        assertEquals(true, map.isFullMap());
    }

    @Test
    public void testFoodCount() {
        assertEquals(0, map.getFoodCount());
        FoodHeart food = new FoodHeart(new Point(0, 0));
        map.addGameObject(food);
        assertEquals(1, map.getFoodCount());
    }

    @Test
    public void testAddRandomFood() {
        assertEquals(0, map.getFoodCount());
        map.addRandomFood();
        assertEquals(1, map.getFoodCount());
    }

    @Test
    public void testWrongPosition() {
        boolean throwed = false;
        try {
            Rock rock = new Rock(new Point(-1, -1));
            map.addGameObject(rock);
        } catch (UnsupportedOperationException e) {
            throwed = true;
        }
        assertTrue(throwed);
    }

    @Test
    public void testAddToOccupiedCell() {
        boolean throwed = false;
        try {
            Rock rock = new Rock(new Point(1, 1));
            Rock secondRock = new Rock(new Point(1, 1));
            map.addGameObject(rock);
            map.addGameObject(secondRock);
        } catch (UnsupportedOperationException e) {
            throwed = true;
        }
    }
}
