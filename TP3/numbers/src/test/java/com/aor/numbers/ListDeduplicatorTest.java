package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {

        class Stub implements IListSorter{
            List <Integer> list;

            Stub(List<Integer> list){
                this.list=list;
            }
            @Override
            public List<Integer> sort() {

                for(int i=0;i<list.size()-1;i++) {
                    int jMin=i;

                    for (int j = i + 1; j < list.size(); j++) {
                        if(this.list.get(j)<this.list.get(jMin)){
                            jMin=j;
                        }
                    }
                    if(jMin!=i){
                        int aux=this.list.get(i);
                        this.list.set(i,this.list.get(jMin));
                        this.list.set(jMin,this.list.get(i));
                    }
                }
                return this.list;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        List<Integer> distinct = deduplicator.deduplicate(new Stub(list));

        assertEquals(expected, distinct);
    }
}