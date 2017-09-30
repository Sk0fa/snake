package View;

import Models.GameMap;
import Models.IGame;
import Models.IGameObject;
import Models.Point;

import java.util.Map;

public class View implements IView{
    
    private Map<IGameObject, Character> objectView;
    
    public View(Map<IGameObject, Character> objectView) {
        this.objectView = objectView;
    }
    
    @Override
    public void redraw(IGame game) {
        GameMap map = game.getMap();
        for(Integer x = 0; x < map.getWidth(); x++) {
            for (Integer y = 0; y < map.getHeight(); y++) {
                Point point = new Point(x, y);
                IGameObject gameObject;
                if(map.isFreeSpace(point))
                    System.out.print(' ');
                else if(objectView.containsKey(gameObject = map.GetMapObject(point)))
                    System.out.print(objectView.get(gameObject));
                else
                    throw new Error("Object " + gameObject.toString() + " was not described");

            }
            System.out.println();
        }
    }
}
