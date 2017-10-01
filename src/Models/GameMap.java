package Models;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;
import java.util.HashMap;

public class GameMap {
    private int width;
    private int height;
    private ArrayList<IGameObject> mapObjects;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapObjects = new ArrayList<IGameObject>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<IGameObject> getMapObjects() {
        return mapObjects;
    }

    public void AddGameObject(IGameObject obj) {
        if (isFreeSpace(obj.getPosition())) {
            mapObjects.add(obj);
            return;
        }

        /*for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                if (isFreeSpace(new Point(i, k))) {
                    obj.setPosition(new Point(i, k));
                    mapObjects.put(obj.getPosition(), obj);
                    return;
                }
            }
        }*/

        throw new UnsupportedOperationException("Space is busy");
    }

    public void AddSnake(Snake snake) {
        if (isFreeSpaceForSnake(snake)) {
            mapObjects.add(snake.getHead());

            for (SnakeTail partOfTail : snake.getTail()) {
                mapObjects.add(partOfTail);
            }
        }
    }

    private boolean isFreeSpaceForSnake(Snake snake) {
        if (isFreeSpace(snake.getHead().getPosition())) {
            for (SnakeTail partOfTail : snake.getTail()) {
                if (!isFreeSpace(partOfTail.getPosition())) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public boolean isFreeSpace(Point point) {
        for (IGameObject obj : mapObjects) {
            if (obj.getPosition().equals(point)) {
                return false;
            }
        }
        return true;
    }

    public IGameObject GetMapObject(Point position) {
        for (IGameObject obj : mapObjects) {
            if (obj.getPosition().equals(position)) {
                return obj;
            }
        }
        return null;
    }
}