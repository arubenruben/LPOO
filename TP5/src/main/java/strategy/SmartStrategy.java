package strategy;

import command.StringDrink;
import command.StringRecipe;
import observer.Bar;
import observer.StringBar;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    List<Order> orderList;


    public SmartStrategy() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()){
            bar.order(drink, recipe);
        }
        else{
            this.orderList.add(new Order(drink, recipe, bar));
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(Order orderToDo:orderList){
            bar.order(orderToDo.getDrink(),orderToDo.getRecipe());
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {
    }
}
