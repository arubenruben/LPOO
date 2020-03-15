package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisibleByFilterTest {


    @Test
    public  void accept(){

        IListFilter filter= new DivisibleByFilter(3);

        boolean result=filter.accept(-1);

        assertEquals(result,false);

        result=filter.accept(3);
        assertEquals(result,true);

        result=filter.accept(6);
        assertEquals(result,true);

        result=filter.accept(0);
        assertEquals(result,true);

        result=filter.accept(-3);
        assertEquals(result,true);

        result=filter.accept(-4);
        assertEquals(result,false);


    }
}
