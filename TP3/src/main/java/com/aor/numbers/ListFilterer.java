package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {

    private List<Integer> list;

    ListFilterer(List<Integer> list){
        this.list=list;
    }

    public List<Integer> filter(IListFilter filter){

        List<Integer>auxReturn=new ArrayList<>();

        for(Integer elem:this.list){
            if(filter.accept(elem)){
                auxReturn.add(elem);
            }
        }
        return auxReturn;
    }

}
