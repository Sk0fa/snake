package Models;

import java.util.*;
import java.util.stream.Collectors;

public class GameMap {
    private int width;
    private int height;
    //TODO: change to hashmap
    private HashMap<Point, IGameObject> mapObjects;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapObjects = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public IGameObject[] getMapObjects() {
        return mapObjects.keySet().toArray(new IGameObject[mapObjects.size()]);
    }

    public void addGameObject(IGameObject obj) {
        if (isFreeSpace(obj.getPosition()))
            mapObjects.put(obj.getPosition(), obj);
        else
            throw new UnsupportedOperationException("Point " + obj.getPosition() +
                    " was occupied");
    }

    public void addSnake(Snake snake) {
        if (isFreeSpaceForSnake(snake)) {
            mapObjects.put(snake.getHead().getPosition(), snake.getHead());
            mapObjects.addAll(snake.getTail());
        }
        else
            throw new UnsupportedOperationException("Not enough place for snake");
    }

    private boolean isFreeSpaceForSnake(Snake snake) {
        return isFreeSpace(snake.getHead().getPosition()) && snake.getTail()
                .stream()
                .allMatch(obj -> isFreeSpace(obj.getPosition()));
    }

    public boolean isFreeSpace(Point point) {
        return mapObjects.stream()
                .noneMatch(obj -> obj.getPosition().equals(point));
    }

    public IGameObject getMapObject(Point position) {
        Optional object = getMapObjectsInCell(position).stream().findFirst();
        return object.isPresent()? (IGameObject) object.get() : new EmptyObject(position);
    }

    public List<IGameObject> getMapObjectsInCell(Point position) {
        return mapObjects.stream()
                .filter(obj -> obj.getPosition().equals(position))
                .collect(Collectors.toList());
    }
}