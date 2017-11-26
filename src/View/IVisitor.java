package View;

import Models.*;

public interface IVisitor {
    void visit(EmptyObject object);
    void visit(FoodHeart food);
    void visit(Rock rock);
    void visit(SnakeHead head);
    void visit(SnakeTail tail);
}
