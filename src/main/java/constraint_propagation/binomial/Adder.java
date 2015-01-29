package constraint_propagation.binomial;

import constraint_propagation.Connector;
import constraint_propagation.Constraint;

public class Adder implements Constraint {
    Connector left, right;
    Connector result;

    public Adder(Connector left, Connector right, Connector result) {
        this.left = left;
        this.right = right;
        this.result = result;

        left.connect(this);
        right.connect(this);
        result.connect(this);
    }

    public void newValue() {
        if (left.hasValue() && right.hasValue()) result.setValue(left.getValue() + right.getValue(), this);
        else if (left.hasValue() && result.hasValue()) right.setValue(result.getValue() - left.getValue(), this);
        else if (right.hasValue() && result.hasValue()) left.setValue(result.getValue() - right.getValue(), this);
    }

    public void forgetValue() {
        left.forgetValue(this);
        right.forgetValue(this);
        result.forgetValue(this);
        newValue();
    }
}
