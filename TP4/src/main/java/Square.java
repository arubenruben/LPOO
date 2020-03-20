public class Square implements AreaShape {
    private double side;

    public Square(double side) {
        super();
        this.side=side;
    }
    public double getSide() {
        return this.side;
    }

    @Override
    public double getArea() {
        return this.side*this.side;
    }

    @Override
    public String draw() {
        return "Square";
    }
}
