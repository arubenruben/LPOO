

public class Elipse extends Shape {

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
}
