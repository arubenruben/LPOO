package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {
    List<Integer> list;
    IListSorter filterStub1;
    IListFilter filterStub;
    List<Integer> expected;


    @Test
    public void filter(){

        ListFilterer filterer=new ListFilterer(this.list);

        List<Integer> filtered=filterer.filter(this.filterStub);

        assertEquals(filtered,this.expected);

    }

    @Before
    public void helper(){
        this.list=new ArrayList<>();
        this.list.add(1);
        this.list.add(-1);
        this.list.add(3);
        this.list.add(-2);
        this.list.add(-4);

        this.expected=new ArrayList<>();
        this.expected.add(1);
        this.expected.add(3);


        this.filterStub= Mockito.mock(IListFilter.class);
        Mockito.when(this.filterStub.accept(1)).thenReturn(true);
        Mockito.when(this.filterStub.accept(-1)).thenReturn(false);
        Mockito.when(this.filterStub.accept(3)).thenReturn(true);
        Mockito.when(this.filterStub.accept(-2)).thenReturn(false);
        Mockito.when(this.filterStub.accept(-4)).thenReturn(false);


    }
}
