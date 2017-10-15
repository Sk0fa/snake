package Models;

public interface IGameObject {
    Point getPosition();
    void setPosition(Point position);
    Character getCharacter();
    Tag getTag();
}
