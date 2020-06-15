package command;

import java.util.Stack;

public class StringInverter extends StringTransformer {
    public StringInverter() {
        super(new Stack<String>());
    }

    @Override
    public void execute(StringDrink drink) {
        history.push(drink.getText());
        StringBuffer stringBuffer=new StringBuffer(drink.getText());
        drink.setText(stringBuffer.reverse().toString());


    }
}
