public class Circle  implements  AreaShape{
    private  double radius;

    public Circle(double radius){
        super();
        this.radius=radius;
    }
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public String draw() {
        return "Circle";
    }
}
