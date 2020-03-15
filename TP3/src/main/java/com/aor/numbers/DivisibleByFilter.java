package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {

    private final int dividend;

    DivisibleByFilter(int dividend){
        this.dividend=dividend;

    }
    @Override
    public boolean accept(Integer number) {
        return (Math.floorMod(number,this.dividend)==0);
    }
}
