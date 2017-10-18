package Models;

public class FoodHeart extends GameObject implements IFood {
    static private Character character = '❤';
    static private int scoreCost = 10;
    static private int foodValue = 1;

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
    public Character getCharacter() {
        return character;
    }

    @Override
    public void solveCollisionWithSnake(Snake snake) {
        disable();
        snake.eatFood(this);
    }

    @Override
    public int getFoodValue() {
        return foodValue;
    }

    @Override
    public int getScoreCost() {
        return scoreCost;
    }

}
