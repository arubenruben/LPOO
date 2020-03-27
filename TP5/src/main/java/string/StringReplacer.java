package string;

public class StringReplacer implements StringTransformer {

    private char originalTo;
    private char finalFor;

    StringReplacer(char originalTo, char finalFor){

        this.originalTo = originalTo;
        this.finalFor = finalFor;
    }
    @Override
    public void execute(StringDrink drink) {
        String initialAux=drink.getText();
        String result=initialAux.replace(originalTo,finalFor);
        drink.setText(result);
    }
}
