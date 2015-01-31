package constraint_propagation;

public class Constant implements Constraint {
    private final int value;
    Connector connector;

    public Constant(int value, Connector connector) {
        this.value = value;
        this.connector = connector;

        connector.connect(this);
        connector.setValue(value, this);
    }

    @Override
    public void newValue() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void forgetValue() {
        throw new UnsupportedOperationException("");
    }
}