package Models;

public abstract class GameObject implements IGameObject {
    protected Point position;
    protected boolean isDead = false;

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
        return isDead;
    }

    @Override
    public void disable() {
        isDead = true;
    }
}
