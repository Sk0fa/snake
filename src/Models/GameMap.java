package Models;

import java.util.Dictionary;
import java.util.Map;
import java.util.HashMap;

public class GameMap {
    private int width;
    private int height;
    private Map<Point, IGameObject> mapObjects;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapObjects = new HashMap<Point, IGameObject>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Point, IGameObject> getMapObjects() {
        return mapObjects;
    }

    public void AddGameObject(IGameObject obj) {
        if (isFreeSpace(obj.getPosition())) {
            mapObjects.put(obj.getPosition(), obj);
            return;
        }

        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                if (isFreeSpace(new Point(i, k))) {
                    obj.setPosition(new Point(i, k));
                    mapObjects.put(obj.getPosition(), obj);
                    return;
                }
            }
        }

        throw new UnsupportedOperationException("Map is full");
    }

    public void AddSnake(Snake snake) {
        if (isFreeSpaceForSnake(snake)) {
            mapObjects.put(snake.getHead().getPosition(), snake.getHead());

            for (Map.Entry<Point, SnakeTail> entry : snake.getTail().entrySet()) {
                mapObjects.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private boolean isFreeSpaceForSnake(Snake snake) {
        if (isFreeSpace(snake.getHead().getPosition())) {
            for (Point point : snake.getTail().keySet()) {
                if (!isFreeSpace(point)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public boolean isFreeSpace(Point point) {
        return mapObjects.containsKey(point) ? false : true;
    }

    public IGameObject GetMapObject(Point position) {
        return getMapObjects().get(position);
    }
}