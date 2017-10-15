package Models;

public class FoodHeart implements IGameObject, IFood {
    private Point position;
    static private Character character = '❤';
    static private int scoreCost = 10;
    private boolean isDead = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodHeart foodHeart = (FoodHeart) o;

        return position != null ? position.equals(foodHeart.position) : foodHeart.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }

    public FoodHeart(Point position) {
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
        return character;
    }

    @Override
    public Tag getTag() {
        return Tag.Food;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void die() {
        isDead = true;
    }

    @Override
    public int getScoreCost() {
        return scoreCost;
    }

}
