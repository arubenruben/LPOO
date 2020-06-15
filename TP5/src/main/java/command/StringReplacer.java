package command;

import java.util.Stack;

public class StringReplacer extends StringTransformer {
    private char original;
    private char result;

    public StringReplacer(char original, char result) {
        super(new Stack<String>());
        this.original = original;
        this.result = result;
    }

    @Override
    public void execute(StringDrink drink) {
        history.push(drink.getText());
        drink.setText(drink.getText().replace(original,result));
    }

}
