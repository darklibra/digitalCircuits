package constraint_propagation.converter;

import constraint_propagation.Connector;
import constraint_propagation.Constant;
import constraint_propagation.binomial.Adder;
import constraint_propagation.binomial.Multiplier;

/**
 * Created by Administrator on 2015-01-29.
 */
public class CelsiusFahrenheit {
    Connector celsius, fahrenheit;

    public CelsiusFahrenheit(Connector celsius, Connector fahrenheit ) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;

        Connector u = new Connector();
        Connector v = new Connector();
        Connector w = new Connector();
        Connector x = new Connector();
        Connector y = new Connector();

        Multiplier multiplier = new Multiplier(celsius, w, u);
        Multiplier multiplier1 = new Multiplier(v, x, u);
        Adder adder = new Adder(v, y, fahrenheit);
        Constant c1 = new Constant(9, w);
        Constant c2 = new Constant(5, x);
        Constant c3 = new Constant(32, y);
    }
}
