package Models;

public class SnakeTail implements IGameObject {
    private Point position;
    private Snake parentSnake;
    private boolean isFullTail;
    private boolean isDead = false;
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

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void die() {
        isDead = true;
    }

    public Snake getSnake() {
        return parentSnake;
    }

    public boolean getIsFullTail() {
        return isFullTail;
    }

    public void setIsFullTail(boolean value) {
        isFullTail = value;
    }
}
