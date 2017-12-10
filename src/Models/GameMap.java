package Models;

import java.io.Serializable;
import java.util.*;

public class GameMap implements Serializable {
    private int width;
    private int height;
    private HashMap<Point, IGameObject> mapObjects;
    private ArrayList<Snake> snakes = new ArrayList<>();

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

    public int getFoodCount() {
        return (int) mapObjects.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(gameObject -> gameObject instanceof IFood)
                .count();
    }


    public boolean isFullMap() {
        return mapObjects.size() == width * height;
    }

    public void addRandomFood() {
        if (!isFullMap()) {
            Point point = getRandomPoint();
            FoodHeart food = new FoodHeart(point);
            addGameObject(food);
        }
    }

    private Point getRandomPoint() {
        Random random = new Random();
        Point point = new Point(random.nextInt(width), random.nextInt(height));
        while (mapObjects.containsKey(point)) {
            point = new Point(random.nextInt(width), random.nextInt(height));
        }
        return point;
    }

    public IGameObject[] getMapObjects() {
        return mapObjects.values().toArray(new IGameObject[mapObjects.size()]);
    }

    public boolean isInsideMap(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public void addGameObject(IGameObject obj) {
        Point objectPosition = obj.getPosition();
        if (isFreeSpace(objectPosition) && isInsideMap(objectPosition))
            mapObjects.put(obj.getPosition(), obj);
        else
            throw new UnsupportedOperationException("Wrong point: " + obj.getPosition());
    }

    public void clearMap() {
        mapObjects.clear();
    }

    public void addSnake(Snake snake) {
        addGameObject(snake.getHead());
        snake.getTail().forEach(this::addGameObject);
        snakes.add(snake);
    }

    public Snake[] getSnakes() {
        return snakes.toArray(new Snake[snakes.size()]);
    }

    public void removeSnake(Snake snake) {
        snakes.remove(snake);
    }

    public boolean isFreeSpace(Point point) {
        return !mapObjects.containsKey(point);
    }

    public IGameObject getMapObject(Point position) {
        if (isFreeSpace(position))
            return new EmptyObject(position);
        return mapObjects.get(position);
    }
}