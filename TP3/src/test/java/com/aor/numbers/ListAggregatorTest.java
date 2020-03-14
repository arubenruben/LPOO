package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ListAggregatorTest {
    private List <Integer> list;
    private ListDeduplicator stubDeduplicator;
    private List<Integer> expected;
    private IListDeduplicator deduplicator;

    @Test
    public void sum() {
    helper();
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(9, sum);
    }

    @Test
    public void max() {
    helper();
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(4, max);
    }

    @Test
    public void min() {
    helper();
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        helper();
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }

    //1, 2, 4 and 2
    @Before
    public void helper(){
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);


        this.expected=new ArrayList<>();
        this.expected.add(1);
        this.expected.add(2);
        this.expected.add(4);

        this.deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate()).thenReturn(this.expected);

    }
}