public class AreaStringOutputter {
    private AreaAggregator aggregator;

    public AreaStringOutputter(AreaAggregator aggregator) {
        this.aggregator=aggregator;
    }

    public double output() {
        return aggregator.sum();
    }
}
