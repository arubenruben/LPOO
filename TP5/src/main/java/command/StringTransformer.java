package command;

import java.util.Stack;

public abstract class  StringTransformer {
    protected Stack<String>history;

    public StringTransformer(Stack<String> history) {
        this.history = history;
    }

    public  abstract  void execute(StringDrink drink);

    public void undo(StringDrink drink){
        drink.setText(history.pop());
    }
}
