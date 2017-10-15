package Models;

public class EmptyObject implements IGameObject {
    private Point position;

    public EmptyObject(Point position) {
        this.position = position;
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
        return ' ';
    }

    @Override
    public Tag getTag() {
        return Tag.EmptyObject;
    }
}
