package composite;

import command.StringDrink;
import command.StringTransformer;

import java.util.List;
import java.util.Stack;

public class StringTransformerGroup extends StringTransformer {
    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        super(new Stack<String>());
        this.transformers = transformers;
    }

    public void execute(StringDrink drink) {
        for(StringTransformer stringTransformer:transformers){
            stringTransformer.execute(drink);
        }
    }
}
