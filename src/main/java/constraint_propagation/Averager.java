package constraint_propagation;

import constraint_propagation.binomial.Adder;
import constraint_propagation.binomial.Multiplier;

public class Averager {
    Connector left, right;
    Connector result;

    public Averager(Connector left, Connector right, Connector result) {
        this.left = left;
        this.right = right;
        this.result = result;

        Connector u = new Connector();
        Connector r = new Connector();

        new Adder(left, right, u);
        new Multiplier(r, result, u);
        new Constant(2, r);
    }
}
