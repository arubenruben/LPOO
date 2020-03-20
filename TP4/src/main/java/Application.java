public class Application {
    public static void main(String[] args) {

        AreaAggregator areaAggregator=new AreaAggregator();
        //...
        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAggregator);

        areaAggregator.addShape(new Circle(5));
        areaAggregator.addShape(new Circle(5));
        areaAggregator.addShape(new Square(5));

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

    }
}

