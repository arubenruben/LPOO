package string;

public class StringBar extends Bar {

    @Override
    public boolean isHappyHour() {
        return super.getHappyHour();
    }

    @Override
    public void startHappyHour() {
        super.setHappyHour(true);
    }

    @Override
    public void endHappyHour() {
        super.setHappyHour(false);
    }
    public void order(StringDrink drink, StringRecipe stringRecipe){
        stringRecipe.mix(drink);
    }
}
