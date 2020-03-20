public class Triangle implements AreaShape {

    private double height;
    private double base;

    Triangle(double height, double base){

        this.height = height;
        this.base = base;
    }
    @Override
    public double getArea() {
        return this.height*this.base/2;
    }

    @Override
    public String draw() {
        return "Triangle";
    }
}
