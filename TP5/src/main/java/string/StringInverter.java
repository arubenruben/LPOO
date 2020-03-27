package string;

public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        char[] arrayCharsAux=drink.getText().toCharArray();
        char[] arrayReverse=new char[arrayCharsAux.length];


        for(int i=0;i<arrayCharsAux.length;i++){
            arrayReverse[i]=arrayCharsAux[arrayCharsAux.length-1-i];
        }

        String result=new String(arrayReverse);

        drink.setText(result);
    }
}
