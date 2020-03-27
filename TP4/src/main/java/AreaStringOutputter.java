public class AreaStringOutputter {
    private SumProvider sumProvider;

    public AreaStringOutputter(SumProvider sumProvider) {
        this.sumProvider=sumProvider;
    }

    public double output() {
        return sumProvider.sum();
    }
}
