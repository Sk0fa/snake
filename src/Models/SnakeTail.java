package Models;

public class SnakeTail implements IGameObject {
    private Point position;
    private Character character;

    public SnakeTail(Point position) {
        this.position = new Point(0, 0);
        this.position.X = position.X;
        this.position.Y = position.Y;
        this.character = '☯';
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
}
