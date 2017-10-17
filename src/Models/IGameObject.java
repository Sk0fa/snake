package Models;

public interface IGameObject {
    Point getPosition();
    void setPosition(Point position);
    Character getCharacter();
    boolean isDead();
    void die();
    void solveCollisionWithSnake(Snake snake);
}
