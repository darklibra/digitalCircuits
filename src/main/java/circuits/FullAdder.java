package circuits;

import component.Wire;
import component.circuits.OrGate;

public class FullAdder {
    public FullAdder(Wire inputA, Wire inputB, Wire inputC, Wire sum, Wire outputC) {
        Wire s = new Wire();
        Wire c1 = new Wire();
        Wire c2 = new Wire();
        HalfAdder ha = new HalfAdder(inputB, inputC, s, c1);
        HalfAdder ha2 = new HalfAdder(inputA, s, sum, c2);
        OrGate og = new OrGate(c1, c2, outputC);
    }
}
