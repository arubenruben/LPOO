package command;

import java.util.Stack;

public class StringCaseChanger extends StringTransformer {

    public StringCaseChanger() {
        super(new Stack<String>());
    }

    @Override
    public void execute(StringDrink drink) {
        history.push(drink.getText());
        StringBuffer stringBuffer=new StringBuffer();

        for(int i=0;i<drink.getText().length();i++){

            if(Character.isLowerCase(drink.getText().charAt(i))){
                stringBuffer.append(Character.toUpperCase(drink.getText().charAt(i)));
            }else
                stringBuffer.append(Character.toLowerCase(drink.getText().charAt(i)));
        }

        drink.setText(stringBuffer.toString());

    }
}
