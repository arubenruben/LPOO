package string;

import static java.lang.Character.*;

public class StringCaseChanger implements  StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String stringAux=drink.getText();

        char[] arrayAux=stringAux.toCharArray();
        char[] arrayResult=new char[arrayAux.length];

        for(int i=0;i<arrayAux.length;i++){

            if(isLowerCase(arrayAux[i])){
                arrayResult[i]=toUpperCase(arrayAux[i]);
            }else{
                arrayResult[i]=toLowerCase(arrayAux[i]);
            }

        }

        String result=new String(arrayResult);
        drink.setText(result);

    }
}
