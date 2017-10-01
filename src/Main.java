import Models.*;
import View.*;
import Controller.*;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap(7, 7);
        Snake snake = new Snake(new Point(3, 3), 2, Direction.Left, map);
        map.AddSnake(snake);
        Map<IGameObject, Character> objectsView = new HashMap<IGameObject, Character>();
        objectsView.put(new SnakeHead(new Point(0, 0), snake), '★');
        objectsView.put(new SnakeTail(new Point(1, 1)), '☯');
        SimpleGame game = new SimpleGame(map);
        View view = new View(objectsView);

        while (true) {
            view.redraw(game);
            game.MakeTurn();
            Thread.sleep(1000);
        }
    }
}
