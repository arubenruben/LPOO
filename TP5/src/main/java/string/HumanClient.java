package string;

public class HumanClient implements Client {

    private OrderingStrategy strategy;

    HumanClient(OrderingStrategy strategy){
        this.strategy=strategy;
    }
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }

    @Override
    public void happyHourStarted(Bar bar) {

    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
