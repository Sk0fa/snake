package Models;

import java.util.ArrayList;

public class GameMap {
    private int width;
    private int height;
    private ArrayList<IGameObject> mapObjects;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapObjects = new ArrayList<>();
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
        if (isFreeSpace(obj.getPosition()))
            mapObjects.add(obj);
        else
            throw new UnsupportedOperationException("Point " + obj.getPosition() +
                    " was occupied");
    }

    public void AddSnake(Snake snake) {
        if (isFreeSpaceForSnake(snake)) {
            mapObjects.add(snake.getHead());
            mapObjects.addAll(snake.getTail());
        }
        else
            throw new UnsupportedOperationException("Not enough place for snake");
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