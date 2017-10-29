package Models;

public abstract class GameObject implements IGameObject {
    protected Point position;
    protected boolean isDisabled = false;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public boolean isDisabled() {
        return isDisabled;
    }

    @Override
    public void disable() {
        isDisabled = true;
    }
}
