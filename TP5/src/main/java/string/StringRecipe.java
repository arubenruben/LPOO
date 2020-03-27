package string;

import java.util.List;

public class StringRecipe {
    private List<StringTransformer> transformers;

    StringRecipe(List<StringTransformer> transformers){

        this.transformers = transformers;
    }

    public void mix(StringDrink drink) {

        for(StringTransformer transformation: transformers){
            transformation.execute(drink);
        }
    }

}
