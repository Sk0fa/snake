package View;

import Models.*;

import java.util.Map;

public class View implements IView{
    
    @Override
    public void redraw(IGame game) {
        GameMap map = game.getMap();
        for(int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Point point = new Point(x, y);
                IGameObject gameObject = map.getMapObject(point);
                System.out.printf("|%c|", gameObject.getCharacter());
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
