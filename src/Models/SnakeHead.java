package Models;

public class SnakeHead implements IGameObject {
    private Point position;
    private Snake snake;
    static private Character character = '★';

    public SnakeHead(Point position, Snake snake) {
        this.position = new Point(position.X,position.Y);
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
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
        IGameObject obj = game.getMap().getMapObject(position);

        if (obj instanceof IFood) {
            game.changeScore(((IFood) obj).getScoreCost());
            snake.addTail();
            ((IFood) obj).destroyFood(game);
        }
    }
}
