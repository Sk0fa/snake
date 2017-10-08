package Models;

public class FoodHeart implements IGameObject, IFood {
    private Point position;
    static private Character character = '❤';
    static private int scoreCost = 10;

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
    public void destroyFood(IGame game) {
        game.getMap().getMapObjects().remove(this);
    }

    @Override
    public int getScoreCost() {
        return scoreCost;
    }

}
