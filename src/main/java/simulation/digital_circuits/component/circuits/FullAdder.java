package simulation.digital_circuits.component.circuits;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.elements.OrGate;

public class FullAdder {
    public FullAdder(Wire inputA, Wire inputB, Wire inputC, Wire sum, Wire outputC) {
        Wire s = new Wire();
        Wire c1 = new Wire();
        Wire c2 = new Wire();
        new HalfAdder(inputB, inputC, s, c1);
        new HalfAdder(inputA, s, sum, c2);
        new OrGate(c1, c2, outputC);
    }
}
