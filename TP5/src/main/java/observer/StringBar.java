package observer;

import command.StringDrink;
import command.StringRecipe;

public class StringBar extends Bar{
    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
