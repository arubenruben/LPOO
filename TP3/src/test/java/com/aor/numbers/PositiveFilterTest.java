package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositiveFilterTest {

    @Test
    public  void accept(){

        IListFilter filter= new PositiveFilter();

        boolean result=filter.accept(-1);

        assertEquals(result,false);

        result=filter.accept(1);
        assertEquals(result,true);

        result=filter.accept(4);
        assertEquals(result,true);

        result=filter.accept(0);
        assertEquals(result,true);

        result=filter.accept(-2);
        assertEquals(result,false);


    }

}
