import Models.*;
import View.*;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        GameMap map = new GameMap(7, 7);
        Snake snake = new Snake(new Point(3, 3), 2,
                Direction.Up, Direction.Right, map);
        FoodHeart heart = new FoodHeart(new Point(3, 0));
        map.addGameObject(heart);
        map.addSnake(snake);
        SimpleGame game = new SimpleGame(map);

        Gui gui = new Gui(game);

        gui.setVisible(true);

    }
}
