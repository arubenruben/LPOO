package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    List<Integer> list;
    List<Integer> bugReport4;
    List<Integer> bugReport5;

    @Test
    public void sum() {
        helper();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        helper();

        ListAggregator aggregator = new ListAggregator(list);

        //Default
        int max = aggregator.max();

        assertEquals(5, max);

        //Ex 4

        ListAggregator aggregatorEx4 = new ListAggregator(this.bugReport4);

        //Default
        int maxBugReport4 = aggregatorEx4.max();

        assertEquals(-1, maxBugReport4);

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
        class Stub implements IListDeduplicator{
            int typeOfTest;
            Stub(int typeOfTest){
                this.typeOfTest=typeOfTest;
            }
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                if(this.typeOfTest==0){

                    List<Integer> listAux=new ArrayList<>();
                    listAux.add(1);
                    listAux.add(2);
                    listAux.add(4);
                    listAux.add(5);

                    return  listAux;

                }else{

                    List<Integer> listAux=new ArrayList<>();
                    listAux.add(1);
                    listAux.add(2);
                    listAux.add(4);

                    return  listAux;
                }
            }
        }

        helper();

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new Stub(0));

        assertEquals(4, distinct);

        //Ex5
        ListAggregator aggregatorBugReport5 = new ListAggregator(this.bugReport5);

        int distinctBugReport5 = aggregatorBugReport5.distinct(new Stub(1));

        assertEquals(3, distinctBugReport5);
    }

    @Before
    public void helper(){
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);
        this.list.add(5);

        this.bugReport4=new ArrayList<>();
        this.bugReport4.add(-1);
        this.bugReport4.add(-4);
        this.bugReport4.add(-5);

        this.bugReport5=new ArrayList<>();
        this.bugReport5.add(1);
        this.bugReport5.add(2);
        this.bugReport5.add(4);
        this.bugReport5.add(2);

        return;
    }
}
