package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void addGameObject(IGameObject obj) {
        if (isFreeSpace(obj.getPosition()))
            mapObjects.add(obj);
        else
            throw new UnsupportedOperationException("Point " + obj.getPosition() +
                    " was occupied");
    }

    public void addSnake(Snake snake) {
        if (isFreeSpaceForSnake(snake)) {
            mapObjects.add(snake.getHead());
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
        return object.isPresent()? (IGameObject) object.get() : null;
    }

    public List<IGameObject> getMapObjectsInCell(Point position) {
        return mapObjects.stream()
                .filter(obj -> obj.getPosition().equals(position))
                .collect(Collectors.toList());
    }
}