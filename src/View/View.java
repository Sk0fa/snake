package View;

import Models.*;

import java.util.Map;

public class View implements IView{
    
    @Override
    public void redraw(IGame game) {
        GameMap map = game.getMap();
        for(Integer x = 0; x < map.getWidth(); x++) {
            for (Integer y = 0; y < map.getHeight(); y++) {
                Point point = new Point(x, y);
                IGameObject gameObject = map.getMapObject(point);
                if(gameObject == null)
                    System.out.print("| |");
                else {
                    System.out.printf("|%c|", gameObject.getCharacter());
                }
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
