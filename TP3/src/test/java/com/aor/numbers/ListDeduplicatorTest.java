package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list;
    List<Integer> expected;

    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(this.list));

        assertEquals(expected, distinct);
    }

    @Before
    public  void helper(){
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(4);
        this.list.add(2);

        this.expected=new ArrayList<>();
        this.expected.add(1);
        this.expected.add(2);
        this.expected.add(4);
    }
}