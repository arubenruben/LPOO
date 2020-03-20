

public class Elipse implements AreaShape {

    private final double xRadius;
    private final double yRadius;

    Elipse(double xRadius, double yRadius){
        super();
        this.xRadius=xRadius;
        this.yRadius=yRadius;
    }

    public double getxRadius() {
        return xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    @Override
    public double getArea() {
        return Math.PI* this.xRadius*this.yRadius;
    }

    @Override
    public String draw() {
        return "Elipse";
    }
}
