package Models;

import View.IVisitor;

public interface IGameObject {
    Point getPosition();
    void setPosition(Point position);
    boolean isDisabled();
    void disable();
    void solveCollisionWithSnake(Snake snake);
    void accept(IVisitor visitor);
}
