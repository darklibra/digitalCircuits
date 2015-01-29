package constraint_propagation;

public interface Constraint {
    public void newValue();
    public void forgetValue();
}
