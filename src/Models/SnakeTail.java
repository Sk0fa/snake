package Models;

public class SnakeTail implements IGameObject {
    private Point position;
    private Snake parentSnake;
    private boolean isFullTail;
    static private Character character = '☯';

    public SnakeTail(Point position, Snake parentSnake, boolean isFullTail) {
        this.position = position;
        this.parentSnake = parentSnake;
        this.isFullTail = isFullTail;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public Tag getTag() {
        return Tag.SnakeTail;
    }

    public Snake getSnake() {
        return parentSnake;
    }

    public boolean getFullTail() {
        return isFullTail;
    }

    public void setFullTail(boolean value) {
        isFullTail = value;
    }
}
