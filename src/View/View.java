package View;

import Models.*;

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
                IGameObject gameObject = map.getMapObject(point);
                if(map.isFreeSpace(point))
                    System.out.print("| |");
                /*else if(objectView.containsKey(gameObject = map.getMapObject(point)))
                    System.out.print(objectView.get(gameObject));*/
                else if (gameObject instanceof SnakeHead) {
                    System.out.print("|★|");
                }
                else if (gameObject instanceof SnakeTail) {
                    System.out.print("|☯|");
                }
                else
                    throw new Error("Object " + gameObject.toString() + " was not described");

            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
