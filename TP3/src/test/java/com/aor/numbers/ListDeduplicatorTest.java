package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        class Stub implements IListSorter{

            @Override
            public List<Integer> sort() {
                List<Integer>listAux =new ArrayList<>();

                listAux.add(1);
                listAux.add(2);
                listAux.add(4);

                return  listAux;

            }
        }

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new Stub());

        assertEquals(expected, distinct);
    }
}