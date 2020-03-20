public class Line implements Shape {
    private double length;

    Line(double length){
        this.length = length;
    }

    @Override
    public String draw() {
        return "Line";
    }
}
