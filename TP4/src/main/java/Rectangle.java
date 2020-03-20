public class Rectangle  implements AreaShape{
    private double width;
    private double height;

    Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    @Override
    public double getArea() {
        return this.width*this.height;
    }

    @Override
    public String draw() {
        return  "Rectangle";
    }
}
