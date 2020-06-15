package command;

import command.StringDrink;
import command.StringInverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringInverterTest {
    @Test
    public void stringInverter() {
        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter();
        si.execute(drink);
        assertEquals("DCBA", drink.getText());
    }

}
