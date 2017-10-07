package Models;

public class SnakeTail implements IGameObject {
    private Point position;
    static private Character character = '☯';

    public SnakeTail(Point position) {
        this.position = new Point(position.X, position.Y);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position.X = position.X;
        this.position.Y = position.Y;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void checkOnCollision(IGame game) {

    }
}
