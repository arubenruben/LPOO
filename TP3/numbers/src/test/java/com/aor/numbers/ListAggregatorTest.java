package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list;
    List<Integer> listBugReport1;
    List<Integer> listBugReport2;
    List<Integer> listBugReport3;

    @Test
    public void sum() {
        //3.1
        //List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        //3.1
        //List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);

        ListAggregator aggregatorBugReport = new ListAggregator(listBugReport1);
        max=aggregatorBugReport.max();
        assertEquals(-1, max);

    }

    @Test
    public void min() {
        //3.1
        //List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        //3.1
        //List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        class Stub implements IListDeduplicator{
            List <Integer> stubList;

            Stub(List<Integer>list){
                this.stubList=list;
            }
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {

                if(this.stubList.equals(list)){
                    List<Integer> stubList= new ArrayList<>();
                    stubList.add(1);
                    stubList.add(2);
                    stubList.add(4);
                    stubList.add(5);
                    return stubList;
                }else{
                    List<Integer> stubList= new ArrayList<>();
                    stubList.add(1);
                    stubList.add(2);
                    stubList.add(4);
                    return stubList;
                }
            }
        }
        int distinct = aggregator.distinct(new Stub(this.list));

        assertEquals(4, distinct);



        distinct = aggregator.distinct(new Stub(this.listBugReport3));

        assertEquals(3, distinct);

    }

    //3.1
    private List<Integer> helper(){
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        return  list;
    }
    @Before
    //3.2
    public void helperBefore(){
        this.list=new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);
        this.list.add(5);

        this.listBugReport1=new ArrayList<>();
        this.listBugReport1.add(-1);
        this.listBugReport1.add(-4);
        this.listBugReport1.add(-5);

        this.listBugReport2=new ArrayList<>();
        this.listBugReport2.add(1);
        this.listBugReport2.add(2);
        this.listBugReport2.add(4);
        this.listBugReport2.add(2);

        this.listBugReport3=new ArrayList<>();
        this.listBugReport3.add(1);
        this.listBugReport3.add(2);
        this.listBugReport3.add(4);

        return;
    }

}