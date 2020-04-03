package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public double getTotal(){
        return this.product.getPrice()*this.quantity;
    }

    @Override
    public String toString() {
        //line.product.getName() + "(x" + line.quantity + "): " + (line.product.getPrice() * line.quantity) + "\n"

        return "product=" + product.getName() + "(x"+ quantity + "): " + (this.product.getPrice() * this.quantity) + "\n";
    }
}
